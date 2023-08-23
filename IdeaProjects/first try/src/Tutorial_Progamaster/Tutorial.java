package Tutorial_Progamaster;

import java.util.Arrays;
import java.util.Scanner;

public class Tutorial {
    public static void main(String[] args) {
        System.out.print("Tutorial.Beni");
        int ot = 5;
        int hat = 6;
        int eredmeny = ot + hat;
        System.out.println(eredmeny);
    }

}

//Új osztály (saját felfedezés)
class Beni {
    public static void main(String[] args) {
        int eredmeny = 1 + 1;
        System.out.println(eredmeny);

    }
}

class gyakorlas {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);

        String myFirststring = sca.nextLine();
        double myFirstdouble = sca.nextDouble();
        int myFirstInt = sca.nextInt();


        System.out.println("String: " + myFirststring + " ");
        System.out.println("Double: " + myFirstdouble + " ");
        System.out.println("Int: " + myFirstInt);


    }
}

class masodikfeladat {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n % 2 != 0) {
            System.out.println("Weird");
        }
        if (n % 2 == 0 && n > 2 && n < 5) {
            System.out.println("Not Weird");
        } else if (n % 2 == 0 && n > 6 && n < 20) {
            System.out.println("Weird");
        } else if (n % 2 == 0 && n > 20) {
            System.out.println("Not Weird");
        }

    }
}

class harmadikfeladat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= 10; i++)
            if (n > 0 && n < 50) {
                int result = (n * i);

                System.out.println(n + " " + "x " + i + " = " + result);
            } else {
                System.out.println("Csak 0 és 50 közötti értéket adhat meg!");
            }


    }
}

class negyedikfealadat {
    public static void main(String[] args) {

        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sca.nextInt();
        }
        sca.close();
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

class otodikfeladat {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);

        String s = sca.nextLine();
        int a = sca.nextInt();
        int b = sca.nextInt();
        System.out.println(s.substring(a, b));
    }
}

class hatodikfeladat {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        String A = sca.next();

        boolean palindrome = true;

        for(int i = 0; i<A.length()/2;i++)
        {
            if(!A.substring(i,i+1).equals(A.substring(A.length()-i-1,A.length()-i)))
            {
                palindrome = false;
            }
        }
        if(palindrome){System.out.println("Yes");}
        else{System.out.println("No");}

        }
    }
  class hetedikfeladat {
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          String[][] numArray = new String[6][];
          int largestSum = 0;
          for(int i=0; i<6; i++){
              numArray[i]=sc.nextLine().split(" ");
          }

          for(int i=0;i<=3;i++){
              for(int j=0;j<=3;j++){
                  int sum = Integer.parseInt(numArray[i][j])+Integer.parseInt(numArray[i][j+1])+Integer.parseInt(numArray[i][j+2])+Integer.parseInt(numArray[i+1][j+1])+Integer.parseInt(numArray[i+2][j])+Integer.parseInt(numArray[i+2][j+1])+Integer.parseInt(numArray[i+2][j+2]);
                  if(i==0 && j==0){
                      largestSum=sum;
                  }else{
                      if(sum>largestSum){
                          largestSum=sum;
                      }
                  }
              }
          }
          System.out.println(largestSum);
      }
  }

  class nyolvadikfeladat {
      public static void main(String[] args) {


      }
  }
  
  
