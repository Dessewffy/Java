package Tutorial_Progamaster;

public class continue_ {
    public static void main(String[] args) {
        //Vezérlő szerkezet ez is
        //Csak ciklusmagon belűl lehet használni!!!
        //Átugor egy utasítást
        //cimkézetlen continue
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) ;
            {
                // Átugorja az összes utasítást a continue után
                continue;
                //System.out.println(i);
            }
        }


    }
}

class cimkezett {
    public static void main(String[] args) {
                                     //cimkézett continue
        //Egymásba ágyazott ciklusoknál van értelme
        String[] dayOfWeek = {"hétfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap"};
        String[] mealsOfDay = {"reggeli", "tizórai", "ebéd", "uzsonna", "vacsora"};
        //Csak ciklus elé lehet: név:           Ez a cimke:
       outer:
        for (String day : dayOfWeek) {
            System.out.println(day);
            inner:
            for (String meal : mealsOfDay) {
                if (day.equals("kedd")) {
                    continue outer; //A keddi étkezéseket nem fogja kiírni!
                }
                System.out.println(meal);

            }
        }
    }
}