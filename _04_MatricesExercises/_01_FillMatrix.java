package _04_MatricesExercises;

import java.util.Scanner;

public class _01_FillMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];
        switch (pattern) {
            case "A":
                CreatePatternA(n);
                break;
            case "B":
                CreatePatternB(n);
                break;
        }
    }
    private static void CreatePatternA(int n) {
        int[][] matrix = new int[n][n];
        for (int row = 1; row <= n; row++) {
            for (int col = row; col <= n * n; col += n) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
    private static void CreatePatternB(int n) {
        int[][] matrix1 = new int[n][n];
        int counter1 = 1;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix1[row][col] = counter1;
                counter1++;
            }
            if (row % 2 != 0) {
                int[] reversedArr = new int[n];
                for (int i = 0; i < n; i++) {
                    reversedArr[i] = matrix1[row][n - 1 - i];
                }
                for (int i = 0; i < n; i++) {
                    matrix1[row][i] = reversedArr[i];
                }
            }
        }
        int[][] matrix2 = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix2[col][row] = matrix1[row][col];
            }
        }
        for (int[] ints : matrix2) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
