package _04_MatricesExercises;

import java.util.Scanner;

public class _03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            String[] input = scanner.nextLine().split(" ");
            System.out.println();
            for (int col = 0; col < n; col++) {
                matrix[row][col]= Integer.parseInt(input[col]);
            }
        }
        int diagonal1 = 0;
        for (int i = 0; i < n; i++) {
            diagonal1 +=  matrix[i][i];
        }
        int diagonal2 = 0;
        for (int i = 0; i < n; i++) {
            diagonal2 += matrix[i][n-1-i];
        }
        int result = Math.abs(diagonal1 - diagonal2);
        System.out.println(result);
    }
}
