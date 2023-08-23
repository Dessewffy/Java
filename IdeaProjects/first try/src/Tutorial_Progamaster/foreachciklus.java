package Tutorial_Progamaster;

public class foreachciklus {
    public static void main(String[] args) {
        int[] myFirstArray = {2, 5, 7, 37, -54, 42};

       //for each ciklus egy tömbnek/objektum minden egyes elemével megcsinálja ugyanazt a folyamatot, ugyanis végig iterál rajta
        //For each csak olvas!!!
        // for (változó :tömb amin szeretnék iterálni) {parancs}

        //I nem  változó, ezért létre kell hozni egy új változót (Itt int tömböt, mert a tömböm is int!!
        for (int Number  : myFirstArray) {
            System.out.println(Number);
        }  
        //Stringel
        String[] StringArray = {"Salve " , "Vale " , "Hi"};
        for (String Array : StringArray) {
            System.out.println(Array);
        }

        //tömbnév.iter  parancsal (környezet függő) Automat megcsinálja
        String[] money = {"Forint" ,  "Font" ,  "Euró"};
        for (String s : money) {
            System.out.println("A tömb következő eleme: "  + s);
        }
        //Ez egy sima for ciklus. Ugyanaz az eredmény, mint a for each ciklusnál, de a for each átláthatóbb
        for (int i = 0; i < money.length; i++) {
            System.out.println(money[i]);
            
        }
    }
}
