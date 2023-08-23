public class Date {

    //Ha ezek mindenki számára láthatóak, akkor mások is használni fogják és nehéz lesz változtatni!
   // Ezért kell a private kulcsszó, de így csak itt látható!
    //Emiatt kell egy setter metódus (automat megcsinálja a intellij )
    private int year;
    int month;
    int day;
//setter/mutator metódus, így néz ki a másik osztályban átírt változó: today.setYear(2023);
    public int setYear(int year) {
      return  this.year = year;
    }

    //Getter metódus/accessor
    public int getYear() {
        return year;
    }


    //Egységbezárás alapján itt meg lehet adni metódust is!

    boolean isMonthValid() {
        return  month >= 1 && month < 12;
    }
    boolean isDayValid() {
        // 31 napos hónapok
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return day>=1 && day<=31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11 ) {
  return day >=1 && day <= 30;
        } else if (month == 2) {
            if (isLeapYear()){
                return day >= 1 && day <= 29;
        }else {
                return day >= 1 && day <= 28;
            }
        }
        return false;
    }

    boolean isLeapYear() {
       boolean divisibleBy4 = year % 4==0;
       boolean divisibleBy100 = year % 100==0;
       boolean divisibleBy400 = year % 400==0;
       return divisibleBy4 && (!divisibleBy100 || divisibleBy400);
    }
}
