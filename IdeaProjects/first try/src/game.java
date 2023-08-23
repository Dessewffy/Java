
import java.util.Random;

public class game {
    //final véglegesít egy értéket (Nem lehet megváltoztatni)
    //static és final egyszerre:fordításidejű konstant, nagybetűvel és _ -el írjuk
    static final int WIDTH = 25;
    static final int HEIGHT = 25;
    static final int GAME_LOOP = 1000;
    static final Random RANDOM = new Random();

    public static void main(String[] args) throws InterruptedException {
        String level[][] = new String[HEIGHT][WIDTH];
        do {
            initlevel(level);
            addRandomWalls(level, 10, 10);
        } while (!isPossible(level, false));


        String player = "a";
        int[] playerStartingCordinate = getRandomStartingCordinate(level);
        int playerRow = playerStartingCordinate[0];
        int playerColumn = playerStartingCordinate[1];
        int[] playerEscapeCordinates = getfarthestCorner(level, playerRow, playerColumn);
        int playerEscapeRow = playerEscapeCordinates[0];
        int playerEscapeColumn = playerEscapeCordinates[1];
        Direction playerDirection = Direction.RIGHT;

        String enemyMark = "-";
        int[] enemyStartingCordinate = getRandomStartingEnemyCordinate(level, playerStartingCordinate, 10);
        int enemyRow = enemyStartingCordinate[0];
        int enemyColumn = enemyStartingCordinate[1];

        int[] enemyEscapeCordinates = getfarthestCorner(level, enemyRow, enemyColumn);
        int enemyEscapeRow = enemyEscapeCordinates[0];
        int enemyEscapeColumn = enemyEscapeCordinates[1];
        Direction enemyDirection = Direction.LEFT;

        String powerUpMark = "*";
        int[] powerUpStartingCordinate = getRandomStartingCordinate(level);
        int powerUpRow = powerUpStartingCordinate[0];
        int powerUpColumn = powerUpStartingCordinate[1];
        boolean powerUpPresentOnLevel = false;
        int powerUpPresenceCounter = 0;
        boolean powerUpActive = false;
        int powerUpActiveCounter = 0;

        GameResult gameResult = GameResult.TIE;

        for (int iterationNumber = 1; iterationNumber <= GAME_LOOP; iterationNumber++) {

            //Játékos léptetése
            if (powerUpActive) {
                // playerDirection = ChangeDirectionTowards(level, playerDirection, playerRow, playerColumn, enemyRow, enemyColumn);
                playerDirection = getShortestPath(level, playerDirection, playerRow, playerColumn, enemyRow, enemyColumn);
            } else {
                if (powerUpPresentOnLevel) {
                    //playerDirection = ChangeDirectionTowards(level, playerDirection, playerRow, playerColumn, powerUpRow, powerUpColumn);
                    playerDirection = getShortestPath(level, playerDirection, playerRow, playerColumn, powerUpRow, powerUpColumn);
                } else {
                    if (iterationNumber % 100 == 0) {

                        playerEscapeCordinates = getfarthestCorner(level, playerRow, playerColumn);
                        playerEscapeRow = playerEscapeCordinates[0];
                        playerEscapeColumn = playerEscapeCordinates[1];
                    }
                    playerDirection = getShortestPath(level, playerDirection, playerRow, playerColumn, playerEscapeRow, playerEscapeColumn);
                }
            }
            int[] playerCordinates = makeMove(playerDirection, level, playerRow, playerColumn);
            playerRow = playerCordinates[0];
            playerColumn = playerCordinates[1];

            //Enemy léptetése
            if (powerUpActive) {
                // Direction directionTowardsplayer = ChangeDirectionTowards(level, enemyDirection, enemyRow, enemyColumn, playerRow, playerColumn);
                //  enemyDirection = getEscapeDirection(level, enemyRow, enemyColumn, directionTowardsplayer);
                if (iterationNumber % 100 == 0) {

                    enemyEscapeCordinates = getfarthestCorner(level, enemyRow, enemyColumn);
                    enemyEscapeRow = enemyEscapeCordinates[0];
                    enemyEscapeColumn = enemyEscapeCordinates[1];
                }
                enemyDirection = getShortestPath(level, enemyDirection, enemyRow, enemyColumn, enemyEscapeRow, enemyEscapeColumn);
            } else {
                // enemyDirection = ChangeDirectionTowards(level, enemyDirection, enemyRow, enemyColumn, playerRow, playerColumn);
                enemyDirection = getShortestPath(level, enemyDirection, enemyRow, enemyColumn, playerRow, playerColumn);
            }
            //csak páros iterációban lép azaz minden másodikban, de úgy túl lassú
            if (iterationNumber % 2 == 0) {
                int[] enemyCordinates = makeMove(enemyDirection, level, enemyRow, enemyColumn);
                enemyRow = enemyCordinates[0];
                enemyColumn = enemyCordinates[1];
            }
            //PoweUp frissítése
            if (powerUpActive) {
                powerUpActiveCounter++;
            } else {
                powerUpPresenceCounter++;
            }
            if (powerUpPresenceCounter >= 50) {
                if (powerUpPresentOnLevel) {
                    powerUpStartingCordinate = getRandomStartingCordinate(level);
                    powerUpRow = powerUpStartingCordinate[0];
                    powerUpColumn = powerUpStartingCordinate[1];
                }
                powerUpPresentOnLevel = !powerUpPresentOnLevel;
                powerUpPresenceCounter = 0;
            }
            if (powerUpActiveCounter >= 40) {
                powerUpActive = false;
                powerUpActiveCounter = 0;
                powerUpStartingCordinate = getRandomStartingCordinate(level);
                powerUpRow = powerUpStartingCordinate[0];
                powerUpColumn = powerUpStartingCordinate[1];

                playerEscapeCordinates = getfarthestCorner(level, playerRow, playerColumn);
                playerEscapeRow = playerEscapeCordinates[0];
                playerEscapeColumn = playerEscapeCordinates[1];
            }

            //Játékos és powerUp interakciója
            if (powerUpPresentOnLevel && playerRow == powerUpRow && playerColumn == powerUpColumn) {
                powerUpActive = true;
                powerUpPresentOnLevel = false;
                powerUpPresenceCounter = 0;
                enemyEscapeCordinates = getfarthestCorner(level, enemyRow, enemyColumn);
                enemyEscapeRow = enemyEscapeCordinates[0];
                enemyEscapeColumn = enemyEscapeCordinates[1];
            }

            draw(level, player, playerRow, playerColumn, enemyMark, enemyRow, enemyColumn, powerUpMark, powerUpRow, powerUpColumn, powerUpPresentOnLevel, powerUpActive);

            extracted(150L, iterationNumber);
            //Játékos és ellenfél azoos kordinátán van
            if (playerRow == enemyRow && playerColumn == enemyColumn) {
                if (powerUpActive) {
                    gameResult = GameResult.WIN;
                } else {
                    gameResult = GameResult.LOOSE;
                }
                break;
            }
        }
        switch (gameResult) {
            case WIN:
                System.out.println("Gratulálok győztél!");
                break;
            case LOOSE:
                System.out.println("Sajnálom vesztettél!");
                break;
            case TIE:
                System.out.println("Döntetlen");
                break;
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------
    static int[] getfarthestCorner(String[][] level, int fromRow, int fromColumn) {
//Pálya lemásolása
        String[][] levelCopy = copy(level);
        //első csillag lehelyyezése a célpontra
        levelCopy[fromRow][fromColumn] = "*";

        int farthestRow = 0;
        int farthestColumn = 0;

        while (spreadAsterisksWithCheck(levelCopy)) {
            Outer:
            for (int row = 0; row < HEIGHT; row++) {
                for (int column = 0; column < WIDTH; column++) {
                    if ("*".equals(levelCopy[row][column])) {
                        farthestRow = row;
                        farthestColumn = column;
                        break Outer;
                    }
                }
            }
        }
        return new int[]{farthestRow, farthestColumn};
    }

    static Direction getShortestPath(String[][] level, Direction defaultDirection, int fromRow, int fromColumn, int toRow, int toColumn) throws InterruptedException {
        //Pálya lemásolása
        String[][] levelCopy = copy(level);
        //első csillag lehelyyezése a célpontra
        levelCopy[toRow][toColumn] = "*";
        while (spreadAsterisksWithCheck(levelCopy)) {


            if ("*".equals(levelCopy[fromRow - 1][fromColumn])) {
                return Direction.UP;
            }
            if ("*".equals(levelCopy[fromRow + 1][fromColumn])) {
                return Direction.DOWN;
            }
            if ("*".equals(levelCopy[fromRow][fromColumn - 1])) {
                return Direction.LEFT;
            }
            if ("*".equals(levelCopy[fromRow][fromColumn + 1])) {
                return Direction.RIGHT;
            }
        }
        return defaultDirection;
    }

    static boolean spreadAsterisksWithCheck(String[][] levelCopy) {
        boolean[][] mask = new boolean[HEIGHT][WIDTH];
        for (int row = 0; row < HEIGHT; row++) {
            for (int column = 0; column < WIDTH; column++) {
                if ("*".equals(levelCopy[row][column])) {
                    mask[row][column] = true;
                }
            }
        }


        boolean changed = false;
        for (int row = 0; row < HEIGHT; row++) {
            for (int column = 0; column < WIDTH; column++)

                if ("*".equals(levelCopy[row][column]) && mask[row][column]) {
                    if (" ".equals(levelCopy[row - 1][column])) {
                        levelCopy[row - 1][column] = "*";
                        changed = true;
                    }
                    if (" ".equals(levelCopy[row + 1][column])) {
                        levelCopy[row + 1][column] = "*";
                        changed = true;
                    }
                    if (" ".equals(levelCopy[row][column - 1])) {
                        levelCopy[row][column - 1] = "*";
                        changed = true;
                    }
                    if (" ".equals(levelCopy[row][column + 1])) {
                        levelCopy[row][column + 1] = "*";
                        changed = true;
                    }
                }
        }
        return changed;
    }

    static boolean isPossible(String[][] level, boolean draw) {
        //Pálya lemásolása
        String[][] levelCopy = copy(level);
        //Első szóköz megkeresése és *-al történő helyettesítése
        Outer:
        for (int row = 0; row < HEIGHT; row++) {
            for (int column = 0; column < WIDTH; column++) {
                if (" ".equals(levelCopy[row][column])) {
                    levelCopy[row][column] = "*";
                    break Outer;
                }
            }
        }
        //*-gok terjesztése a szabad helyekre (if + ciklusok kellenek?)
        while (spreadAsterisks(levelCopy)) {
            if (draw) {
                for (int row = 0; row < HEIGHT; row++) {
                    for (int column = 0; column < WIDTH; column++) {
                        System.out.println(levelCopy[row][column]);
                    }
                    System.out.println();

                }
            }
        }
        //pályamásolat vizsgálata:maradt-e szóköz valahol?
        for (int row = 0; row < HEIGHT; row++) {
            for (int column = 0; column < WIDTH; column++) {
                if (" ".equals(levelCopy[row][column])) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean spreadAsterisks(String[][] levelCopy) {
        boolean changed = false;
        for (int row = 0; row < HEIGHT; row++) {
            for (int column = 0; column < WIDTH; column++)

                if ("*".equals(levelCopy[row][column])) {
                    if (" ".equals(levelCopy[row - 1][column])) {
                        levelCopy[row - 1][column] = "*";
                        changed = true;
                    }
                    if (" ".equals(levelCopy[row + 1][column])) {
                        levelCopy[row + 1][column] = "*";
                        changed = true;
                    }
                    if (" ".equals(levelCopy[row][column - 1])) {
                        levelCopy[row][column - 1] = "*";
                        changed = true;
                    }
                    if (" ".equals(levelCopy[row][column + 1])) {
                        levelCopy[row][column + 1] = "*";
                        changed = true;
                    }
                }
        }
        return changed;
    }

    static String[][] copy(String[][] level) {
        String[][] copy = new String[HEIGHT][WIDTH];
        for (int row = 0; row < HEIGHT; row++) {
            for (int column = 0; column < WIDTH; column++) {
                copy[row][column] = level[row][column];
            }

        }
        return copy;
    }

    static Direction getEscapeDirection(String[][] level, int enemyRow, int enemyColumn, Direction directionTowardsplayer) {
        Direction escapeDirection = getOppositeDirection(directionTowardsplayer);
        switch (escapeDirection) {
            case UP:
                if (level[enemyRow - 1][enemyColumn].equals(" ")) {
                    return escapeDirection;
                } else if (level[enemyRow][enemyColumn - 1].equals(" ")) {
                    return Direction.LEFT;
                } else if (level[enemyRow][enemyColumn + 1].equals(" ")) {
                    return Direction.RIGHT;
                } else {
                    return Direction.UP;
                }
            case DOWN:
                if (level[enemyRow + 1][enemyColumn].equals(" ")) {
                    return Direction.DOWN;
                } else if (level[enemyRow][enemyColumn - 1].equals(" ")) {
                    return Direction.LEFT;
                } else if (level[enemyRow][enemyColumn + 1].equals(" ")) {
                    return Direction.RIGHT;
                } else {
                    return Direction.DOWN;
                }
            case RIGHT:
                if (level[enemyRow][enemyColumn + 1].equals(" ")) {
                    return Direction.RIGHT;
                } else if (level[enemyRow - 1][enemyColumn].equals(" ")) {
                    return Direction.LEFT;
                } else if (level[enemyRow + 1][enemyColumn].equals(" ")) {
                    return Direction.RIGHT;
                } else {
                    return Direction.RIGHT;
                }
            case LEFT:
                if (level[enemyRow][enemyColumn - 1].equals(" ")) {
                    return Direction.LEFT;
                } else if (level[enemyRow - 1][enemyColumn].equals(" ")) {
                    return Direction.LEFT;
                } else if (level[enemyRow + 1][enemyColumn].equals(" ")) {
                    return Direction.RIGHT;
                } else {
                    return Direction.UP;
                }
        }
        return escapeDirection;
    }

    static Direction getOppositeDirection(Direction direction) {
        switch (direction) {
            case UP:
                return Direction.DOWN;
            case DOWN:
                return Direction.UP;
            case RIGHT:
                return Direction.LEFT;
            case LEFT:
                return Direction.RIGHT;
            default:
                return direction;
        }
    }

    //Ellenség kezdő hely sorsolás
    static int[] getRandomStartingEnemyCordinate(String[][] level, int[] playerStartingCordinate, int distance) {
        int playerStartingRow = playerStartingCordinate[0];
        int playerStartingColumn = playerStartingCordinate[1];
        int randomRow;
        int randomColumn;
        int counter = 0;
        do {
            randomRow = RANDOM.nextInt(HEIGHT);
            randomColumn = RANDOM.nextInt(WIDTH);

        } while (counter++ < 1000
                && (!level[randomRow][randomColumn].equals(" ") || calculateDistance(randomRow, randomColumn, playerStartingRow, playerStartingColumn) < distance));
        return new int[]{randomRow, randomColumn};
    }

    static int calculateDistance(int Row1, int Column1, int Row2, int Column2) {
        //Math.abs megadja egy szám abszolút értékét
        int rowDifference = Math.abs(Row1 - Row2);
        int columnDifference = Math.abs(Column1 - Column2);
        return rowDifference + columnDifference;

    }

    //Játékos kezdőhely sorsolás
    static int[] getRandomStartingCordinate(String[][] level) {
        int randomRow;
        int randomColumn;
        do {
            randomRow = RANDOM.nextInt(HEIGHT);

            randomColumn = RANDOM.nextInt(WIDTH);

        } while (!level[randomRow][randomColumn].equals(" "));
        return new int[]{randomRow, randomColumn};
    }

    //Ellenfél kövesse a játékost
    static Direction ChangeDirectionTowards(String[][] level, Direction originalEnemyDirection, int enemyRow, int enemyColumn, int playerRow, int playerColumn) {
        if (playerRow < enemyRow && level[enemyRow - 1][enemyColumn].equals(" ")) {
            return Direction.UP;
        }
        if (playerRow > enemyRow && level[enemyRow + 1][enemyColumn].equals(" ")) {
            return Direction.DOWN;
        }
        if (playerColumn < enemyColumn && level[enemyRow][enemyColumn - 1].equals(" ")) {
            return Direction.LEFT;
        }
        if (playerColumn > enemyColumn && level[enemyRow][enemyColumn + 1].equals(" ")) {
            return Direction.RIGHT;
        }
        return originalEnemyDirection;
    }

    static void addRandomWalls(String[][] level, int numberOfHorizontalWalls, int numberOfVerticalWalls) {
        for (int i = 0; i < numberOfHorizontalWalls; i++) {
            addHorizontalWall(level);
        }
        for (int i = 0; i < numberOfVerticalWalls; i++) {
            addVerticalWall(level);
        }
    }

    static void addHorizontalWall(String[][] level) {

        //Fal szélessége
        int wallWidth = RANDOM.nextInt(WIDTH - 3);
        //Fal elhelyezkedése
        int wallRow = RANDOM.nextInt(HEIGHT - 2) + 1;
        int wallColumn = RANDOM.nextInt(WIDTH - 2 - wallWidth);
        for (int i = 0; i < wallWidth; i++) {
            level[wallRow][wallColumn + i] = "X";
        }

    }

    static void addVerticalWall(String[][] level) {
        //Fal szélessége
        int wallHeight = RANDOM.nextInt(HEIGHT - 3);
        //Fal elhelyezkedése
        int wallRow = RANDOM.nextInt(HEIGHT - 2 - wallHeight);
        int wallColumn = RANDOM.nextInt(WIDTH - 2) + 1;
        for (int i = 0; i < wallHeight; i++) {
            level[wallRow + i][wallColumn] = "X";
        }
    }

    private static void extracted(long timeout, int iterationNumber) throws InterruptedException {
        System.out.println("-----" + iterationNumber + "--------");
        Thread.sleep(timeout);
    }

    static void draw(String[][] board, String player, int playerRow, int playerColumn, String enemyMark, int enemyRow, int enemyColumn, String powerUpMark, int powerUpRow, int powerUpColumn, boolean powerUpPresentOnLevel, boolean powerUpActive) {
        //Játékos és pálya kirajzolása

        for (int Row = 0; Row < HEIGHT; Row++) {
            for (int Column = 0; Column < WIDTH; Column++) {
                if (Row == playerRow && Column == playerColumn) {
                    System.out.print(player);
                } else if (Row == enemyRow && Column == enemyColumn) {
                    System.out.print(enemyMark);
                } else if (powerUpPresentOnLevel && Row == powerUpRow && Column == powerUpColumn) {
                    System.out.print(powerUpMark);
                } else {

                    System.out.print(board[Row][Column]);
                }
            }
            System.out.println();
        }
        if (powerUpActive) {
            System.out.println("A powerup aktív");
        }
    }

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
            for (int column = 0; column < level[row].length; column++) {
                if (row == 0 || row == HEIGHT - 1 || column == 0 || column == WIDTH - 1) {
                    level[row][column] = "X";
                } else {
                    level[row][column] = " ";
                }
            }
        }
    }

    static int[] makeMove(Direction direction, String[][] level, int row, int column) {
        switch (direction) {
            case UP:
                if (level[row - 1][column].equals(" ")) {
                    row--;
                }
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
