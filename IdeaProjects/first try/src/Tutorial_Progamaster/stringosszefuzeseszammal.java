package Tutorial_Progamaster;

public class stringosszefuzeseszammal {
    public static void main(String[] args) {
        String firststring = "Hello world";
        //Simán összeírja (egybe)
        System.out.println(firststring + 5);

        //De a sorrendiség problematikus, ha számmal kezded és Tutorial.string majd szám, akkor :3hello4 lesz az eredmény.
        //Ha összeadást követ Tutorial.string, akkor egymásutánba leírja: 34hello (Számot stringé alakítja)

        int a = 3;
        int b = 4;
        int c = 5;
        int d = 6;
        //()-es művelet előre való!! Azaz azzal kezdi a gép és így nem konvertálja stringé!! a c+d-t. " " a space

        System.out.println(a + b + " " + firststring + " " +(c + d));
        //Eredmény:7Hello world11



    }
}
