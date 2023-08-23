public class character {
    //CharType-ot én hoztam létre enumként
    charType type;
    String name;
    int level = 1;
    int strength = 20;
    int dexterity = 20;
    int intelligence = 20;

    public boolean isLevelValid() {
        return level >= 1 && level <= 100;
    }

    public boolean isCharStatValid() {
        if (strength > 0 && dexterity > 0 && intelligence > 0) {
            return isCharStatValid(); //Itt ez jó? Vagy True kéne ide?
        } else return false;

    }

    public boolean isTypeValid() {

        return type != null;


    }
    public boolean isNameValid() {
        return name !=null && name.length()>= 3 && name.length()<=20;
    }
}
