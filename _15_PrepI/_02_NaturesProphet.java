package _15_PrepI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class _02_NaturesProphet {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[][] matrix;
    static List<int[]> specialFlowers = new ArrayList<>();
    static int rows;
    static int cols;

    public static void main(String[] args) throws IOException {
        readTheInput();
        activateTheSpecialFlowers();
        printTheOutputMatrix();
    }

    private static void printTheOutputMatrix() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void activateTheSpecialFlowers() {
        for (int[] specialFlower : specialFlowers) {
            int currRow = specialFlower[0];
            int currCol = specialFlower[1];
            //change vertical
            for (int row = 0; row < rows; row++) {
                matrix[row][currCol]++;
            }
            matrix[currRow][currCol]--;
            //change horizontal
            for (int col = 0; col < cols; col++) {
                matrix[currRow][col]++;
            }
        }
    }

    private static void readTheInput() throws IOException {
        String[] matrixDimentions = bf.readLine().split("\\s+");
        rows = Integer.parseInt(matrixDimentions[0]);
        cols = Integer.parseInt(matrixDimentions[1]);
        fillTheMatrtix(rows, cols);

        String line = bf.readLine();
        while (!"Bloom Bloom Plow".equals(line)) {
            int[] tokens = Stream.of(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int currRow = tokens[0];
            int currCol = tokens[1];
            int[] currArr = new int[2];
            currArr[0] = currRow;
            currArr[1] = currCol;
            specialFlowers.add(currArr);
            line = bf.readLine();
        }
    }

    private static void fillTheMatrtix(int rows, int cols) {
        matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = 0;
            }
        }
    }
}
