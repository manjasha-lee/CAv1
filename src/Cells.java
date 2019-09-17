import java.util.Scanner;
public class Cells {
    public static void main(String[] args) {

        CellsParameters A1 = new  CellsParameters (1.1,"пшеница");
        CellsParameters A2 = new  CellsParameters (2.2,"овес");
        CellsParameters A3 = new  CellsParameters (3.3,"кукуруза");
        CellsParameters A4 = new  CellsParameters (1.1,"кукуруза");
        CellsParameters A5 = new  CellsParameters (2.2,"пшеница");
        CellsParameters A6 = new  CellsParameters (3.3,"овес");
        CellsParameters A7 = new  CellsParameters (1.1,"кукуруза");
        CellsParameters A8 = new  CellsParameters (2.2,"овес");
        CellsParameters A9 = new  CellsParameters (3.3,"пшеница");

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

        Object[] CellsArr = new Object[] {A1, A2, A3, A4, A5, A6, A7, A8, A9};

        System.out.println("Введите количество желаемых объемов засева пшеницей в Га (не более 19,8):");
        Scanner pshenitsa = new Scanner(System.in);
        System.out.println("Введите количество желаемых объемов засева кукурузой в Га (не более" + 19,8 - pshenitsa +"):");// стринг преобразовать в double!
        Scanner kukuruza = new Scanner(System.in);
        Scanner oves = new Scanner(System.in);

    }
    public static int ChoiceCrop(Object Arr[]){
        for (int i = 0; i < Arr.length; i++) {

        }
    }
}
