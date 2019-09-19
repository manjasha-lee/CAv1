import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Cells {
    public static void main(String[] args) {

        CellsParameters a1 = new CellsParameters(1.1, "пшеница");
        CellsParameters a2 = new CellsParameters(2.2, "овес");
        CellsParameters a3 = new CellsParameters(3.3, "кукуруза");
        CellsParameters a4 = new CellsParameters(1.1, "кукуруза");
        CellsParameters a5 = new CellsParameters(2.2, "пшеница");
        CellsParameters a6 = new CellsParameters(3.3, "овес");
        CellsParameters a7 = new CellsParameters(1.1, "кукуруза");
        CellsParameters a8 = new CellsParameters(2.2, "овес");
        CellsParameters a9 = new CellsParameters(3.3, "пшеница");

        a1.SetNeighboursE(a2);
        a2.SetNeighboursW(a1);
        a2.SetNeighboursS(a5);
        a2.SetNeighboursE(a3);
        a3.SetNeighboursW(a2);
        a3.SetNeighboursS(a6);
        a4.SetNeighboursN(a1);
        a4.SetNeighboursE(a5);
        a4.SetNeighboursS(a7);
        a5.SetNeighboursN(a2);
        a5.SetNeighboursE(a6);
        a5.SetNeighboursS(a8);
        a5.SetNeighboursW(a4);
        a6.SetNeighboursN(a3);
        a6.SetNeighboursS(a9);
        a6.SetNeighboursW(a5);
        a7.SetNeighboursN(a4);
        a7.SetNeighboursE(a8);
        a8.SetNeighboursN(a5);
        a8.SetNeighboursE(a9);
        a8.SetNeighboursW(a7);
        a9.SetNeighboursN(a6);
        a9.SetNeighboursW(a8);

        CellsParameters[] cellsArr = new CellsParameters[]{a1, a2, a3, a4, a5, a6, a7, a8, a9};

        System.out.println("Введите необходимую площадь земли для засева пшеницей в Га (не более 19.8):");
        Scanner pshenitsa = new Scanner(System.in);
        double itogoPshenitsa = pshenitsa.nextFloat();
        double balanceGa = 19.8 - itogoPshenitsa;

        System.out.println("Введите необходимую площадь земли для засева кукурузой в Га (не более " + balanceGa + "):");
        Scanner kukuruza = new Scanner(System.in);
        double itogoKukuruza = kukuruza.nextFloat();
        double itogoOves = balanceGa - itogoKukuruza;

        System.out.print("Площадь земли для засева овсом в Га равен: ");
        System.out.printf("%.2f", itogoOves);
        System.out.println(" ");

        for (int i = 0; i < cellsArr.length; i++) {
            ArrayList <String> variantCrop = new ArrayList();
            ArrayList <Double> ballCrop = new ArrayList();

            String cellPredecessorCrop = cellsArr[i].predecessor;
            double areaFieldCell = cellsArr[i].fieldCell;
            String currentNeighbourN = " ";
            String currentNeighbourE = " ";
            String currentNeighbourS = " ";
            String currentNeighbourW = " ";

            if (cellsArr[i].neighbourNorth != null) {
                currentNeighbourN = cellsArr[i].neighbourNorth.bestVariantCrop;
            }
            if(cellsArr[i].neighbourEast != null) {
                currentNeighbourE = cellsArr[i].neighbourEast.bestVariantCrop;
            }
            if (cellsArr[i].neighbourSouth != null) {
                currentNeighbourS = cellsArr[i].neighbourSouth.bestVariantCrop;
            }
            if (cellsArr[i].neighbourWest != null){
                currentNeighbourW = cellsArr[i].neighbourWest.bestVariantCrop;
            }

            if (i == 0) {
                countByPredecessor(cellPredecessorCrop, variantCrop, ballCrop);
                countByNecessaryCrop(itogoPshenitsa, itogoKukuruza, itogoOves, areaFieldCell, variantCrop, ballCrop);

                double maxBall = Collections.max(ballCrop, Double::compare);//получаем максимальный балл
                int indexMaxBall = ballCrop.indexOf(maxBall);//получаем индекс максимального балла в коллекции

                cellsArr[i].SetBestVariantCrop(variantCrop.get(indexMaxBall));// устанавливаем культуру с максимальным баллом культурой клетки
                System.out.println("Клетка а"+(i+1)+" - культура: "+cellsArr[i].bestVariantCrop);
            }else {
                countByPredecessor(cellPredecessorCrop, variantCrop, ballCrop);
                countByNecessaryCrop(itogoPshenitsa, itogoKukuruza, itogoOves, areaFieldCell, variantCrop, ballCrop);
                countByNeighdors(currentNeighbourN, currentNeighbourE, currentNeighbourS, currentNeighbourW, variantCrop, ballCrop);

                double maxBall = Collections.max(ballCrop, Double::compare);//получаем максимальный балл
                int indexMaxBall = ballCrop.indexOf(maxBall);//получаем индекс максимального балла в коллекции

                cellsArr[i].SetBestVariantCrop(variantCrop.get(indexMaxBall));// устанавливаем культуру с максимальным баллом культурой клетки
                System.out.println("Клетка а"+(i+1)+" - культура: "+cellsArr[i].bestVariantCrop);


            }
        }
    }

    public static void countByPredecessor(String cellPredecessor, ArrayList <String> arrVariantCrop, ArrayList <Double> arrBallCrop) {
        if (cellPredecessor.equals("кукуруза")){
            arrVariantCrop.add("кукуруза");
            arrBallCrop.add(10.0);
            arrVariantCrop.add("пшеница");
            arrBallCrop.add(10.0);
        }else if (cellPredecessor.equals("пшеница")){
            arrVariantCrop.add("кукуруза");
            arrBallCrop.add(5.0);
            arrVariantCrop.add("пшеница");
            arrBallCrop.add(10.0);
            arrVariantCrop.add("овес");
            arrBallCrop.add(5.0);
        }else if (cellPredecessor.equals("овес")) {
            arrVariantCrop.add("кукуруза");
            arrBallCrop.add(10.0);
            arrVariantCrop.add("овес");
            arrBallCrop.add(0.0);
        }
    }
    public static void countByNecessaryCrop(double xItogoPshenitsa, double xItogoKukuruza, double xItogoOves, double xFieldCell, ArrayList <String> arrVariantCrop, ArrayList <Double> arrBallCrop){
        for (int j = 0; j < arrVariantCrop.size() ; j++) {

            System.out.println(arrVariantCrop.get(j)+ " " + arrBallCrop.get(j));

            if (arrVariantCrop.get(j).equals("кукуруза")){
                double currentScore = arrBallCrop.get(j);
                currentScore += xItogoKukuruza;
                arrBallCrop.set(j,currentScore);

                xItogoKukuruza -= xFieldCell;
            }else if(arrVariantCrop.get(j).equals("пшеница")){
                double currentScore = arrBallCrop.get(j);
                currentScore += xItogoPshenitsa;
                arrBallCrop.set(j,currentScore);

                xItogoPshenitsa -= xFieldCell;
            }else if(arrVariantCrop.get(j).equals("овес")) {
                double currentScore = arrBallCrop.get(j);
                currentScore += xItogoOves;
                arrBallCrop.set(j, currentScore);

                xItogoOves -= xFieldCell;
            }
        }
    }
    public static void countByNeighdors(String neighborN, String neighborE, String neighborS, String neighborW, ArrayList <String> arrVariantCrop, ArrayList <Double> arrBallCrop){
        for (int i = 0; i < arrVariantCrop.size(); i++) {
           if (arrVariantCrop.get(i).equals(neighborN) || arrVariantCrop.get(i).equals(neighborE) || arrVariantCrop.get(i).equals(neighborS)||arrVariantCrop.get(i).equals(neighborW)){
               double currentScore = arrBallCrop.get(i);
               currentScore-= 10.0;
               arrBallCrop.set(i,currentScore);
           }
        }
    }
}
