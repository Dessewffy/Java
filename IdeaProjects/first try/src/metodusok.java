public class metodusok {
    //main kötelező
    //Tutorial.Tutorial.Main metódus után,de a class-on belül
    //Lehet rá hivatkozni és ami benne van azt megcsinálja újra > kód újra felhasználás

    //ctr + alt +m -el automat megcsinálja a meglévő kód metódussá alakítását.

    //KÓD VÉGÉN VAN AZ ANYAG

    //Metódus túltöltés: 2 metódus van azonos névvel, de eltérő paraméter változókkal

    //Osztályváltozók:
    static int width = 15;
    static int height = 15;
    static int gameLoop = 100;

    public static void main(String[] args) throws InterruptedException {


        String player = "a";
        int playerRow = 2;
        int playerColumn = 2;
        Direction playerDirection = Direction.RIGHT; //Importáltam az Direction enumomat.

        String enemyMark = "-";
        int enemyRow = 7;
        int enemyColumn = 4;
        Direction enemyDirection = Direction.LEFT; //Importáltam az Direction enumomat.

        String level[][] = new String[height][width];
        initlevel(level);


        //Ez a hányszor fusson le, mozgókép efektus
        for (int iterationNumber = 1; iterationNumber <= gameLoop; iterationNumber++) {

            //Játékos léptetése
            if (iterationNumber % 15 == 0) {
                //Meghívom a changedirection metódust (Kód alul, akkor lenne jó ez ha többször fordulna elő a kódban)
                playerDirection = changeDirection(playerDirection);
            }
            //Meghívom a makeMove-ot és egy új változóba mentem, majd abból olvasom ki a row-ot és a column-t
            int[] playerCordinates = makeMove(playerDirection, level, playerRow, playerColumn);
            playerRow = playerCordinates[0];
            playerColumn = playerCordinates[1];

            //Enemy léptetése
            if (iterationNumber % 10 == 0) {
                //Meghívom a changedirection metódust (Kód alul, akkor lenne jó ez ha többször fordulna elő a kódban)
                enemyDirection = changeDirection(enemyDirection);
            }
            //Meghívom a makeMove-ot és egy új változóba mentem, majd abból olvasom ki a row-ot és a column-t
            int[] enemyCordinates = makeMove(enemyDirection, level, enemyRow, enemyColumn);
            enemyRow = enemyCordinates[0];
            enemyColumn = enemyCordinates[1];

            //Meghívom a draw metódust és átadom a main metódus adatait, azaz alul a player a mark volt, de itt írhatok playert, mert itt tudja értelmezni, maga a logika ugyanaz!
            //De a sorrendre figyelj! A board volt az első ami egy 2d tömb volt, ahogy itt a level is!
            draw(level, player, playerRow, playerColumn, enemyMark, enemyRow, enemyColumn);
            //Ezt a ctr + alt + m gomb kombóval automat hoztam létre!
            extracted(150L, iterationNumber);
        }


//jelleg(static)  eredmény(void-semmi) metódus név(draw) () {}
        //ált void-ot írunk,
        //később nem fogsz statikus metódusthasználni
    }

    private static void extracted(long timeout, int iterationNumber) throws InterruptedException {
        System.out.println("-----" + iterationNumber + "--------");
        Thread.sleep(timeout);
    }

    //Itt ki a akarom rajzolni a pályát, ezért kell String ()-be [paraméter változó a nevük itt jönnek létre>csak ezen {}-on belül érvényesek!!]
    static void draw(String[][] board, String player, int playerRow, int playerColumn, String enemyMark, int enemyRow, int enemyColumn) {
        //Játékos és pálya kirajzolása
        for (int Row = 0; Row < height; Row++) {
            for (int Column = 0; Column < width; Column++) {
                if (Row == playerRow && Column == playerColumn) {
                    System.out.print(player);
                } else if (Row == enemyRow && Column == enemyColumn) {
                    System.out.print(enemyMark);
                } else {

                    System.out.print(board[Row][Column]);
                }

            }
            System.out.println();

        }
    }

    //()-jelben a bemeneti paraméterek, ami itt a Direction tipusú direction változó)
    static Direction changeDirection(Direction direction) {
        //Irányváltoztatás
        switch (direction) {
            case RIGHT:
                direction = Direction.DOWN;
                break;
            case DOWN:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.UP;
                break;
            case UP:
                direction = Direction.RIGHT;
                break;
        }
        return direction;


    }

//Pályarajz
    static void initlevel(String[][] level) {
        for (int row = 0; row < level.length; row++) {
            for (int column = 0; column < level[row].length; column++) { // level[row].lengh így kell kiíratni egy 2d tömbö elemeit
                if (row == 0 || row == height - 1 || column == 0 || column == width - 1) { //height és a width olytályváltozóként van az elején, ez a pálya széle)
                    level[row][column] = "X"; //Pálya szél inicializálása
                } else {
                    level[row][column] = " ";
                }//itt feltöltöm szóközzel a tömböt
            }


        }
    }

    //Itt a metódusba nem írhatok void-ot, mert return-el adok vissza értéket!!
    static int[] makeMove(Direction direction, String[][] level, int row, int column) {
        switch (direction) {
            case UP:
                if (level[row - 1][column].equals(" ")) {
                    row--;
                } //Itt mondom meg neki, hogy nem mehet ki a pélyéról (Minden irányra be van állítva)
                break;
            case DOWN:
                if (level[row + 1][column].equals(" ")) {
                    row++;
                }

                break;
            case LEFT:
                if (level[row][column - 1].equals(" ")) {
                    column--;
                }

                break;
            case RIGHT:
                if (level[row][column + 1].equals(" ")) {
                    column++;
                }

                break;
        }
        return new int[]{row, column};

    }
}
