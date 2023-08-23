package Tutorial_Progamaster;

public class egymasnaagyazottciklusok {
    public static void main(String[] args) {
        //Ha ki akarom iratni, hogy hanyadik sorban vagyok éppen, beágyazok egy új ciklust

        //Bármelyik ciklust be lehet ágyazni egy másikba

        for (int i = 1; i <= 5; i++) { //ha itt átírom i-t 0-ra akkor 0-tól fogja kezdeni
            //A parancs részbe kell beírni a köv ciklust
            for (int j = 1; j < i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        //Egymásba ágyazott ciklusok és feltétel vizsgálatok

        //Ha azt akarom, hogy minden PÁROS számt írjon csak ki, beágyazok egy if-et (feltételt)
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.println(i);

            }


        }
    }
}
