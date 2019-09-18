import java.util.ArrayList;
import java.util.Scanner;
public class Cells {
    public static void main(String[] args) {

        CellsParameters A1 = new CellsParameters(1.1, "пшеница");
        CellsParameters A2 = new CellsParameters(2.2, "овес");
        CellsParameters A3 = new CellsParameters(3.3, "кукуруза");
        CellsParameters A4 = new CellsParameters(1.1, "кукуруза");
        CellsParameters A5 = new CellsParameters(2.2, "пшеница");
        CellsParameters A6 = new CellsParameters(3.3, "овес");
        CellsParameters A7 = new CellsParameters(1.1, "кукуруза");
        CellsParameters A8 = new CellsParameters(2.2, "овес");
        CellsParameters A9 = new CellsParameters(3.3, "пшеница");

        A1.SetNeighboursE(A2);
        A2.SetNeighboursW(A1);
        A2.SetNeighboursS(A5);
        A2.SetNeighboursE(A3);
        A3.SetNeighboursW(A2);
        A3.SetNeighboursS(A6);
        A4.SetNeighboursN(A1);
        A4.SetNeighboursE(A5);
        A4.SetNeighboursS(A7);
        A5.SetNeighboursN(A2);
        A5.SetNeighboursE(A6);
        A5.SetNeighboursS(A8);
        A5.SetNeighboursW(A4);
        A6.SetNeighboursN(A3);
        A6.SetNeighboursS(A9);
        A6.SetNeighboursW(A5);
        A7.SetNeighboursN(A4);
        A7.SetNeighboursE(A8);
        A8.SetNeighboursN(A5);
        A8.SetNeighboursE(A9);
        A8.SetNeighboursW(A7);
        A9.SetNeighboursN(A6);
        A9.SetNeighboursW(A8);

        ArrayList <String> variantCrop = new ArrayList();
        ArrayList <Double> ballCrop = new ArrayList();

        Object[] CellsArr = new Object[]{A1, A2, A3, A4, A5, A6, A7, A8, A9};

        System.out.println("Введите количество желаемых объемов засева пшеницей в Га (не более 19.8):");
        Scanner pshenitsa = new Scanner(System.in);
        double itogoPshenitsa = pshenitsa.nextFloat();
        double balanceGa = 19.8 - itogoPshenitsa;

        System.out.println("Введите количество желаемых объемов засева кукурузой в Га (не более " + balanceGa + "):");
        Scanner kukuruza = new Scanner(System.in);
        double itogoKukuruza = kukuruza.nextFloat();
        double itogoOves = balanceGa - itogoKukuruza;

        System.out.print("Количество желаемых объемов засева овсом в Га равен: ");
        System.out.printf("%.2f", itogoOves);

    }

    public static void CountByPredecessor(String cellPredecessor, ArrayList <String> arrVariantCrop, ArrayList <Double> arrBallCrop) {
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
        }
    }
    public static void CountByWishesCrop (double xItogoPshenitsa, double xItogoKukuruza, double xItogoOves, double xFieldCell, ArrayList <String> arrVariantCrop, ArrayList <Double> arrBallCrop){
        for (int j = 0; j < arrVariantCrop.size() ; j++) {
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
    public static void CountByNeighdors (String neighborN, String neighborE, String neighborS, String neighborW, ArrayList <String> arrVariantCrop, ArrayList <Double> arrBallCrop){
        for (int i = 0; i < arrVariantCrop.size(); i++) {
           if (arrVariantCrop.get(i).equals(neighborN) || arrVariantCrop.get(i).equals(neighborE) || arrVariantCrop.get(i).equals(neighborS)||arrVariantCrop.get(i).equals(neighborW)){
               double currentScore = arrBallCrop.get(i);
               currentScore-= 100.0;
               arrBallCrop.set(i,currentScore);
           }
        }
    }
}
