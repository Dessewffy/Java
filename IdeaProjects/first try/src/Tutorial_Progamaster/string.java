package Tutorial_Progamaster;

public class string {
    public static void main(String[] args) {
        //olyan, mint a primitívek (számok + boolean)
        //Nagybetű a String!!!!!
        String myfirststring = "Hello world";
        System.out.println(myfirststring);
        //A kiíratáshoz nem kell Tutorial.string parancs
        System.out.println("Tutorial.Beni a király");

                                //Stringek összefűzése (concat)

        //Ez nem szép!
        System.out.println("Hello" + " " + "World");
        //Ez a összefűzés
        String mystring = "Hello " + "World";
        System.out.println(mystring);
        //Vagy ("" a space jele)
        String elso = "Szia";
        String masodik = "Tutorial.Beni";
        System.out.println(elso + " " + masodik);

        //Vagy egyesíted egy stringbe
        String finalstring = elso + " " + mystring;
        System.out.println(finalstring);

                                              //SubString (String egy részét használjuk fel

        String exampleString = "Fekete bikapata kopog a patika pepita kövén";
        //.subString parancsal működik, zárójelbe az index szám (0-tól kezdődik = első betű 0)
        System.out.println(exampleString.substring(4));
        //te bikapata kopog a patika pepita kövén fog kiírni

        //lehet kettő számt is!
        //Fontos:Első index belekerül! Második már NEM!, ezért 15-öt írtam)
        System.out.println(exampleString.substring(7 , 15));



    }
}
