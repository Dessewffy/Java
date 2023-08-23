package Tutorial_Progamaster;

public class elseif {
    public static void main(String[] args) {
        //Ha több változó közül kell, akkor if else
        /* így néz ki:

        if ( )  {
        } else {   }
         */

        int a = 7;
        if (a % 2 == 0) {
            System.out.println("A változó kettővel osztható");
        }
        else if (a % 3 == 0) {
            System.out.println("Osztható 3-mal");
        }
        else if (a % 5 == 0) {
            System.out.println("Osztható 5-el");
        } else {
            System.out.println("Nem osztható egyikkel sem");
        }
    }
}
