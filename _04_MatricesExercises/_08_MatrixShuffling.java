package _04_MatricesExercises;

import java.util.Scanner;

public class _08_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        String[][] matrix = new String[rows][cols];

        matrix = FillTheMatrix(rows, cols, matrix, scanner);

        ReadSwapPrint(matrix, scanner);
    }

    private static void ReadSwapPrint(String[][] matrix, Scanner scanner) {
        while (true) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            if (command.equals("END")) {
                return;
            } else if (!command.equals("swap")) {
                System.out.println("Invalid input!");
                continue;
            }
            try {
                int row1 = Integer.parseInt(input[1]);
                int col1 = Integer.parseInt(input[2]);
                int row2 = Integer.parseInt(input[3]);
                int col2 = Integer.parseInt(input[4]);
                String[][] depo = new String[matrix.length][matrix[0].length];
                depo[0][0] = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = depo[0][0];
                PrintMatrix(matrix);

            } catch (Exception e) {
                System.out.println("Invalid input!");
                continue;
            }
        }
    }

    private static void PrintMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] FillTheMatrix(int rows, int cols, String[][] matrix, Scanner scanner) {

        for (int row = 0; row < rows; row++) {
            String[] scanLine = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanLine[col];
            }
        }
        return matrix;
    }
}
