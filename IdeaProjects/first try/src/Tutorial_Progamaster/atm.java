package Tutorial_Progamaster;

import java.util.Scanner;
//Feladat: ATM program írás, kérjen pénz összeget be, majd megadott cimletek alapján adja ki az összeget.
//pl.: 25 ezer => 1 db 20 ezeres és egy 5 ezres

//57 295 ft a kivenni kívánt összeg
public class atm {
    public static void main(String[] args) {
        //Tutorial.Tutorial.Scanner a bevitel végett
        Scanner scanner = new Scanner(System.in);
        int moneyAmount;
        do {
            System.out.print("Kérem adjon meg egyy ösezzeget: ");
            moneyAmount = scanner.nextInt();
            System.out.println("A megadott összeg: " + moneyAmount + " forint.");
            if (moneyAmount < 0) {
                System.out.println("Kérem 0-nál nagyobb címletet adjon meg!");
            }
            if (moneyAmount % 5 != 0) {
                System.out.println("Kérem 5-el osztható címletet írjon be!");
            }
        } while (moneyAmount < 0 || moneyAmount % 5 != 0);

        //Írj egy tömböt a címleteknek
        int[] currencies = {20000, 100000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5};
        //moneyAmount elmentése
        int remainingAmount = moneyAmount;
        //Kell egy tömb, hogy hány 20, 10 stb ezres kell
        int[] pieces = new int[currencies.length];

        /*
        //57 295 ezer osztása 20 ezerrel (currencies[0] = 20 ezer, 0. indexű elem)
        pieces[0] = remainingAmount / currencies[0];
        //Frissítem a remainingAmount értékét, %-val képzek maradékot 17ezer majd ezzel is megcsinálom ezt, de 1 indexel osztom azaz 10 ezerrel és így haladok tovább
        remainingAmount = remainingAmount % currencies[0];
        //És végig megyek a tömbön és a pieces indexét is növelem (mert abba mentem az eredméynt)

        pieces[1] = remainingAmount / currencies[1];
        remainingAmount = remainingAmount % currencies[1];
        pieces[2] = remainingAmount / currencies[2];
        remainingAmount = remainingAmount % currencies[2];
        pieces[3] = remainingAmount / currencies[3];
        remainingAmount = remainingAmount % currencies[3];
        //Ezt 11x kéne ismételnem, mert annyi címletem van, de ez túl hosszú
        //kell egy for

         */
        for (int i = 0; i < currencies.length; i++) {
            pieces[i] = remainingAmount / currencies[i];
            remainingAmount = remainingAmount % currencies[i];
            //if kell, hogy ne írja ki a nullákat.
            if (pieces[i] > 0) {
                if (currencies[i] > 200)
                    System.out.println(pieces[i] + "db " + currencies[i] + " forintos bankjegy");
                else {
                    System.out.println(pieces[i] + "db " + currencies[i] + " forintos érme");

                }
            }

        }
        System.out.println("Kérem vegye ki az összeget a gépből!");
    }


}




