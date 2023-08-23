package Tutorial_Progamaster;

public class iplusplus {
    public static void main(String[] args) {
                                //i++ hozzáad egyszer a változónkhoz
        int i = 1;
        System.out.println(i);
        //Itt módosítom az értékét (már definiáltam - nem kell az int mégegyszer), de ez így hosszú (9 karakter)
        i = i + 1;
        System.out.println(i);
        //Így rövidebb, itt 3 lesz mert feljebb hozzáadtál már egyet
        i++;
        System.out.println(i);

        //Nem kell i-nek nevezni, lehet double is
        double apple = 1.3;
        System.out.println(apple);
        apple++;
        System.out.println(apple);


    }


}
