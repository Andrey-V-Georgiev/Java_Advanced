package _03_MatricesLab;

import java.util.Scanner;

public class _02_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] frame = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(frame[0]);
        int cols = Integer.parseInt(frame[1]);
        int[][] matrix = new int[rows][cols];
        long sum = 0;
        for (int row = 0; row < rows; row++) {
            String[] lineInput = scanner.nextLine().split(", ");
            for (int col = 0; col < cols; col++) {
                    matrix[row][col]= Integer.parseInt(lineInput[col]);
                    sum+=matrix[row][col];
            }
        }
        System.out.printf("%d%n%d%n%d%n",rows,cols,sum);
    }
}
