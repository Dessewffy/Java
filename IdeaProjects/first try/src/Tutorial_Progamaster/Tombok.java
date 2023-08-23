package Tutorial_Progamaster;

import java.util.Arrays;

public class Tombok {
    public static void main(String[] args) {
        // Tömbök (Array)

        /* Lehet primitív, String etc
           Adat tárolás a feladatuk
         */

        int[] myFirstArray = {2, 5, 7, 34, -54, 7};
        //New int [] tömb esetén meg kel adnom, hogy hány elem lesz benne (Ha kiíratom 3 db 0-t ír)
        int[] anotherArray = new int[3];

        //Itt magát a tömböt írja ki ([Ljava.lang.String;@48140564) Ezt kell konvertálni! Csak stringnél!
        String[] Array = {"Java", "C++", "Python"};
        System.out.println(Array);
        //Megoldás (Arrays.toString(ide kell a tömb));
        System.out.println(Arrays.toString(Array));


        //Elemek a tömbön belül

        int[] MyFirstArray = {2, 5, 7, 34, -54, 42};
        //[]-jelbe kell írni az indexszámot
        System.out.println(MyFirstArray[0]);
        System.out.println(MyFirstArray[5]);

        //felülírás: Tömb[indexszám] = új érték;
        MyFirstArray[0] = 10;
        System.out.println(Arrays.toString(MyFirstArray));


    }
}
