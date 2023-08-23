package Tutorial_Progamaster;

public class egymasbaagyazottif {
    public static void main(String[] args) {
        /*
        If-en belüli feltétel vizsgálat: i (állítás) {következmény/új feltétel!}
        if (a + b == 3) {
        if (a / b == 3 )   System.out.println("Egyenlő érték"); }
        */

        int a = 12;
        if (a % 2 == 0) {
            if (a % 3 == 0) System.out.println("A változó osztható 6-al, így 2-vel és 3-al is");
            else {
                System.out.println("A változó 2-vel osztható, de 3-al nem, így 6-al sem");
            }

        } else if (a % 3 == 0) {
            System.out.println("Osztható 3-mal, de 2-vel nem, így 6-al sem");
        } else {
            System.out.println("Nem osztható se 2-vel, se 3-al, se 6-al");

        }
        System.out.println("Ez a prgoram végén van!");
    }

}
