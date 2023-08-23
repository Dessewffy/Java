public class switch_utasitas {
    public static void main(String[] args) {
        //Döntéshozó az if-hez hasonlóan
                                    //switch utasítás
        //switch () {case 1:  ; case 2: ;  etc. break + default ha kell}
        //a break azért kell, mert különben végig fut pl.:Itt a szerdától!
        int dayOfWeek = 3;
        switch (dayOfWeek) {
            case 1: System.out.println("Hétfő");break;
            case 2: System.out.println("Kedd");break;
            case 3: System.out.println("Szerda");break;
            case 4: System.out.println("Csütörtök");break;
            case 5: System.out.println("Péntek");break;
            case 6: System.out.println("Szombat");break;
            case 7: System.out.println("Vasárnap");break;
            //default nem kötelező, ha kell ha egyik eset se fut le. Bárhol lehet!
            default:
                System.out.println("Kérem adjon meg egy számot 1 és 7 között");


        }
    }
}
                                            //switch kifejezés
/*
class masodik {
    public static void main(String[] args) {
        int dayOfWeek = 3;
        String nameOfDay = switch (dayOfWeek) {
            // - > -nél nem kell break!
            case 1 ->  "Hétfő"; //CSAK JAVA 14+ MŰKÖDIK!!!!!
            case 2 -> "Kedd";
            case 3 -> "Szerda";
            case 4 ->  "Csütörtök";
            case 5 -> "Péntek";
            case 6 -> "Szombat";
            case 7 -> "Vasárnap";
            //Lehet művelet erdménye is
            case 8 -> {3 + 4 yield Pirosalma}; //CSAK JAVA 14+ MŰKÖDIK!!!!! yield azt jelenti eredményez
            default -> "ismeretlen";
        };

    }
}

 */