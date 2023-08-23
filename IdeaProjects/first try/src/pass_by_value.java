public class pass_by_value {
    public static void main(String[] args) {

        //Eltérő a primitívek és a referencia értékek memóriatárolása
        int test = 42;
        System.out.println("teszt értéke: " + test);

        //Megpróbálom egy metódussal felülírni
        tryModify(test);
        System.out.println("teszt értéke: " + test);
    }

    // Itt a test egy teljesen más változó!!(paraméterváltozó) Lehetne alma is.
    static void tryModify(int test) {
        test = 52;
    }


    static class nemPrimitív {

        public static void main(String[] args) {

            Date test = new Date();
            test.setYear(2023);
            test.month = 1;
            test.day = 23;
            System.out.println(test.setYear(2023));
            System.out.println(test.month);
            System.out.println(test.day);
            Modify(test);
            System.out.println(test.setYear(2023));
            System.out.println(test.month);
            System.out.println(test.day);
        }
//Itt működik!(Mert objektumot írtam felül azaz refernciaértéket és nem primitívet!!!!)
      static void Modify(Date test) {
            test.setYear(2010);

        }
    }
}


