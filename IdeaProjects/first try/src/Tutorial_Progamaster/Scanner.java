package Tutorial_Progamaster;

public class Scanner {
    public static void main(String[] args) {

        //Tutorial.Tutorial.Scanner létrehozása és a szöveg bekérésse

        //1. Tutorial.Tutorial.Scanner deklarálása
        //2. Ad meg a nevét
        //3.new parancs majd Tutorial.Tutorial.Scanner parancs
        //4. zárójelbe beírod a forrást (Itt a konzol) Sytem parancs majd külső/belső forrás (in/out) itt in.
        java.util.Scanner sca =  new java.util.Scanner(System.in);

        //Itt a változó értékének a helyére írod: Tutorial.Tutorial.Scanner nevét(sca).nextLine() parancsot
        //nextLine String esetében és ilyenkor Stringként definiálod az elején!
        String myFrirstString = sca.nextLine();
        System.out.println(myFrirstString + "!");
        //Ezután a konzolra tudsz írni!
        //Gondolom külső parancsnál képes a szerver infót befogadni



                                    //Tutorial.Tutorial.Scanner használata szám bekérésére

        java.util.Scanner beni = new java.util.Scanner(System.in);
        //Int esetében
        //Scaner név.nextInt parancs
        int myNumber = beni.nextInt();
        System.out.println(myNumber * 10);

        //Tutorial.Tutorial.Scanner név.nextDouble() ha törtbe akarod. , kell használnod (2,5) !!!!!!
       double tort = beni.nextDouble();
       System.out.println(tort * 15);



       //Ha több mindent akarsz kiíratni, ugyanazzal a Scannerrel
        java.util.Scanner tobb = new java.util.Scanner(System.in);
        int anothernumber = tobb.nextInt();
        //int után egy üres scannernév.nextLine()
        tobb.nextLine();
        String anotherString = tobb.nextLine();
        System.out.println(anothernumber * 10 + anotherString);

    }
}
