import java.util.Arrays;

public class twodarray {
    public static void main(String[] args) {


        //2 D tömbök [][] jellel kel jelölni és  { {}, {} } jelek közé kell írni
        int[][] array = {{1, 2, 3, 4, 5}, {12}, {12, 987, 65, 4}};
        int[][] anotherArray = {{1, 2, 3, 4, 5}, {12}, {12, 987, 65, 4}};


        //Ez a public static void display(int x [] [])-hez kötődik, enélkül nem írja ki!
        display(array);
        display(anotherArray);

    }


    public static void display(int x[][]) {
        //Most kell 2 cilus, hogy tábla legyen az adatokból
        //Ez a sorok ciklusa (row)

        for (int row = 0; row < x.length; row++) {
            for (int column = 0; column < x[row].length; column++) {
                System.out.print(x[row][column] + "\t");
            }
            //Ez ad hozzá új row-ot
            System.out.println();
        }
    }

}

class kettődimenzióstömb {
    public static void main(String[] args) {
        //tömb létrehozása
        int[][] tömb = new int [4] [6];

        //elemek tárolása tömben
         tömb [1] [2] = 42;

         //elemek kiolvasása
        System.out.println(tömb[1] [2]);

        //Referencia tipusoknál (pl.:Tutorial.string)
        String [] [] stringarray = new String[4] [5];
        stringarray [1] [3] = "Tutorial.Beni";
        System.out.println(stringarray[1] [3]);
     }

        }
