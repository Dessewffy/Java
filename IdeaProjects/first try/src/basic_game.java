public class basic_game {
    public static void main(String[] args) throws InterruptedException {
        String level[][] = new String[10][10];
        String player = "a";
        int row = 2;
        int column = 2;
        Direction direction = Direction.RIGHT; //Importáltam az Direction enumomat.

        //Pálya inicializálása
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) { // level[i].lengh így kell kiíratni egy 2d tömbö elemeit
                if (i == 0 || i == 9 || j == 0 || j == 9) {
                    level[i][j] = "X"; //Pálya szél inicializálása
                } else {
                    level[i][j] = " ";
                }//itt feltöltöm szóközzel a tömböt
            }


        }
        //Ez a hányszor fusson le, mozgókép efektus
        for (int k = 1; k <= 100; k++) {
            if (k % 10 == 0) {
                //Irányváltoztatás
                switch (direction) {
                    case RIGHT:
                        direction = Direction.DOWN;
                        break;
                    case DOWN:
                        direction = Direction.LEFT; break;
                    case LEFT:
                        direction = Direction.UP;
                        break;
                    case UP:
                        direction = Direction.RIGHT;
                        break;
                }
            }
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


            //Játékos és pálya kirajzolása
            for (int i = 0; i < level.length; i++) {
                for (int j = 0; j < level[i].length; j++) {
                    if (i == row && j == column) {
                        System.out.print(player);
                    } else {

                        System.out.print(level[i][j]);
                    }

                }
                System.out.println();

            }
            System.out.println("---------------");
            Thread.sleep(500L);
        }
    }
}