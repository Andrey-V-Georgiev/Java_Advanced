package _15_PrepI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _03_ChessKnight {
    static String[][] matrix;
    static List<Move> moves;
    static BufferedReader bf;
    static List<String> collectedItems;
    static int invalidMoves;
    static int outOfBoundMoves;
    static int startRow;
    static int startCol;
    static int currRow;
    static int currCol;

    public static void main(String[] args) throws IOException {
        matrix = new String[8][8];
        moves = new ArrayList<>();
        collectedItems = new ArrayList<>();
        readTheInput();
        doTheMoves();
        printResults();
    }

    private static void printResults() {
        System.out.printf("Pieces take: %s%n", collectedItems.toString()
                .replace("[", "").replace("]", ""));
        System.out.printf("Invalid moves: %d%n", invalidMoves);
        System.out.printf("Board out moves: %d%n", outOfBoundMoves);
    }

    private static void doTheMoves() {
        currRow = startRow;
        currCol = startCol;
        int counter = 0;
        for (Move move : moves) {
            counter++;
            if (validMove(move)) {
                if (move.getEndRow() > 7 || move.getEndRow() < 0 || move.getEndCol() > 7 || move.getEndCol() < 0) {
                    outOfBoundMoves++;
                } else {
                    currRow = move.getEndRow();
                    currCol = move.getEndCol();
                    if (!" ".equals(matrix[currRow][currCol])) {
                        String item = matrix[currRow][currCol];
                        collectedItems.add(item);
                        matrix[currRow][currCol] = " ";
                    }
                }
            } else {
                invalidMoves++;
                continue;
            }
        }
    }

    private static boolean validMove(Move move) {
        int currStartRow = move.getStartRow();
        int currStartCol = move.getStartCol();
        int currEndRow = move.getEndRow();
        int currEndCol = move.getEndCol();

        if ((currEndRow == currStartRow - 2 && currEndCol == currStartCol - 1)
                || (currEndRow == currStartRow - 2 && currEndCol == currStartCol + 1)
                || (currEndRow == currStartRow - 1 && currEndCol == currStartCol + 2)
                || (currEndRow == currStartRow + 1 && currEndCol == currStartCol + 2)
                || (currEndRow == currStartRow + 2 && currEndCol == currStartCol + 1)
                || (currEndRow == currStartRow + 2 && currEndCol == currStartCol - 1)
                || (currEndRow == currStartRow + 1 && currEndCol == currStartCol - 2)
                || (currEndRow == currStartRow - 1 && currEndCol == currStartCol - 2)
                ) {

            return true;
        }
        return false;
    }

    private static void readTheInput() throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        //fill matrix
        for (int i = 0; i < 8; i++) {
            String[] line = bf.readLine().split("\\|");
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = line[j];
            }
        }
        //read the startPosition
        String startRead = bf.readLine();
        startRow = startRead.charAt(0) - 48;
        startCol = startRead.charAt(1) - 48;
        if (startRow < 0 || startRow > 7 || startCol < 0 || startCol > 7){
            return;
        }
            //fill moves
            String[] line = bf.readLine().split(" -> ");
        while (!"END".equals(line[0])) {
            Move newMove = new Move();
            newMove.setStartRow(line[0].charAt(0) - 48);
            newMove.setStartCol(line[0].charAt(1) - 48);
            newMove.setEndRow(line[1].charAt(0) - 48);
            newMove.setEndCol(line[1].charAt(1) - 48);
            moves.add(newMove);
            line = bf.readLine().split(" -> ");
        }
    }


    public static class Move {
        private int startRow;
        private int startCol;
        private int endRow;
        private int endCol;

        public Move() {
        }

        public Move(int name, int startRow, int startCol, int endRow, int endCol) {
            this.startRow = startRow;
            this.startCol = startCol;
            this.endRow = endRow;
            this.endCol = endCol;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getStartCol() {
            return startCol;
        }

        public void setStartCol(int startCol) {
            this.startCol = startCol;
        }

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getEndCol() {
            return endCol;
        }

        public void setEndCol(int endCol) {
            this.endCol = endCol;
        }
    }
}
