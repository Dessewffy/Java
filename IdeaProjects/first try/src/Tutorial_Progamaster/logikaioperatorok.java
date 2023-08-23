package Tutorial_Progamaster;

public class logikaioperatorok {
    public static void main(String[] args) {
        /*logikai operátorok
        ==
        >
        <
        >= Nagyobb egyenlő
        <= Kisebb egyenlő
        != Nem egyenlő
        ! és logikai operátor megfordítja a jelentéssét (Kivéve:><)
            De az egész állításnál ok p: !(a > b)
        || vagy
        ? : feltételes hármas
         */


        int a = 3;
        int b = 5;

        if (a > b) {
            System.out.println("A feltétel igaz");
        }

        if (a % 2 == 0 || b % 2 == 0) {
            System.out.println("Az egyik páros");
        }
        //Else-t én írtam ide, direkt páratlanok az int-ek
        else System.out.println("Egyik sem páros");

        //Feltételes hármas
        //Bal oldal ha igaz, jobboldal ha hamis.
        // állítás ? kiírandó : kiírandó

        int i = 55;
        System.out.println(i % 2 == 0 ? "Páros": "Páratlan");
    }





}


