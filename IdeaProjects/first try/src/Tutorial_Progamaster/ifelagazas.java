package Tutorial_Progamaster;

public class ifelagazas {
    public static void main(String[] args) {
                //if elágazás (Függvény?)
        // if (állítás) {következmény}

        int i = 4;
        if (i % 2 == 0) {
            System.out.println("A szám páros");
        }

        //String egyenlőség vizsgálata
        // == nem túl jó a Stringeknél!!!! inkább a  .equals parancs jobb!!!
        String a = "alma";
        String b = "alma";
        if (a.equals(b)) {
            System.out.println("a és b egyenlő");
        }


    }
}
