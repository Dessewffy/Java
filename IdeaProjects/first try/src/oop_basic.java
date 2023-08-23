public class oop_basic {
    public static void main(String[] args) {
        //OOP = Object Oriented Programming

        // A Date-el és a character-el egybe tartozik ez az anyag!


        //OOP elvei:
        /*
        1.egységbezárás = encapsulation
            -Összetartózó részek egybe írása a kódban

        2.Öröklődés = inheritance
            Újra hasznosítani egy kódot

        3.polimorfizmus = polymorphiism
            Korábbi metódusok újrafelhasználása más definícióval(Mást csinál, mint korábban)

        4.absztrakció = abstraction
            Valós világ elemeinek modellezése a kódban

         */

        //Date egy sajt változó egy külön class fájlban
        Date today = getToday();
        //setter metódus miatt írtam át
        today.setYear(2023);
        today.month = 1;
        today.day = 23;

        boolean birthDay = isBirthDay(today);
        if (birthDay) {
            System.out.println("Boldog szülinapot!");
        }
        //Így tudom kiíratni a metódus eredményét.(Date class-ba írtam)
        System.out.println("Nap helyes? " + today.isDayValid());
        System.out.println("Hónap helyes? " + today.isMonthValid());
        System.out.println("Év helyes? " + today.isLeapYear());

    }

    static boolean isBirthDay(Date date) {
        return date.month == 1 && date.day == 23;
    }

    static Date getToday() {
        Date date = new Date();
        date.setYear(2023);
        date.month = 1;
        date.day = 23;
        //Visszatérni csak 1 értékkel lehet, de az objektum maga egy, ami többet tartalmaz!
        return date;
    }
}
