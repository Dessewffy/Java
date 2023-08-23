package Tutorial_Progamaster;

public class Break {
    public static void main(String[] args) {
        //Vezérlés átadó
        //Van cimkézett/nem cimkézett
        //switch és ciklusban működik
        //cimkézetlen break
        int[] numbers = {65, 23, 12, 77, 99, 23, -3, 42, 99};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 99) ;
            System.out.println("99 szerepel a számok között");
            break; //Nem megy tovább a második 99-re! (Különben 2x írná ki!)
        }


        //cimkézett break
        String[] dayOfWeek = {"hétfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap"};
        String[] mealsOfDay = {"reggeli", "tizórai", "ebéd", "uzsonna", "vacsora"};
        //Csak ciklus elé lehet: név:           Ez a cimke:
        outer:
        for (String day : dayOfWeek) {
            System.out.println(day);
            inner:
            for (String meal : mealsOfDay) {
                if (day.equals("csütörtök")) {
                    break outer; //A keddi étkezéseket nem fogja kiírni continue-nál, de a breaknél megáll csütörtöknél!!!
                }                  // Külső ciklus áll le!
                System.out.println(meal);

            }
        }
    }
}
