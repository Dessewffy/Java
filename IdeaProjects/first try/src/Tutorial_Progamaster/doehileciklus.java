package Tutorial_Progamaster;

public class doehileciklus {
    public static void main(String[] args) {
        //Itt előre kerül cselekvés és csak utána a feltétel vizsgálat!
        // Do{mit csináljon} while (feltétel)

        int a = 2;
        do {
            System.out.println(a);
            a = a * 2;
        } while (a < 1000);

    }
}
