package Tutorial_Progamaster;

import java.util.Arrays;

public class Tombokbejarasaforciklussal {
    public static void main(String[] args) {
        //Tömbök bejárása for cilussal
        int[] myFirstArray = {2, 5, 7, 37, -54, 42};
        int[] anotherArray = new int[5];
        for (int i = 0; i < myFirstArray.length; i++) {
            System.out.println("A tömb egyik eleme: "+ myFirstArray[i]);
        }
        //itt feltöltöm a tömböt 5-ig, mivel: int[] anotherArray = new int[5]; azaz 5 elemes lehet a tömb!
        for (int i = 0; i < anotherArray.length; i++) {
            anotherArray[i] = i + 1;
            System.out.println(Arrays.toString(anotherArray));
        }
    }
}
