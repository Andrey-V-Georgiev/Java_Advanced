package _03_MatricesLab;

import java.util.Scanner;

public class _03_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] frame = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(frame[0]);
        int cols = Integer.parseInt(frame[1]);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] lineInput = scanner.nextLine().split(", ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(lineInput[col]);
            }
        }
        int maxRow = 0;
        int maxCol = 0;
        int maxSum = 0;
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int currentSum = matrix[row][col] +
                        matrix[row][col + 1] +
                        matrix[row + 1][col] +
                        matrix[row + 1][col + 1];
                if (currentSum > maxSum) {
                    maxRow = row;
                    maxCol = col;
                    maxSum = currentSum;
                }
            }
        }
        System.out.printf("%d %d%n", matrix[maxRow][maxCol], matrix[maxRow][maxCol + 1]);
        System.out.printf("%d %d%n", matrix[maxRow + 1][maxCol], matrix[maxRow + 1][maxCol + 1]);
        System.out.println(maxSum);
    }
}
