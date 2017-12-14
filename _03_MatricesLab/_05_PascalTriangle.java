package _03_MatricesLab;

import java.util.Scanner;

public class _05_PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        long[][] matrix = new long[n][];

        matrix[0]= new long[1];
        matrix[0][0] = 1;

        for (int row = 1; row < n; row++) {
            matrix[row]= new long[row+1];
            matrix[row][0] = 1;
            matrix[row][row] = 1;
            for (int col = 1; col <= row - 1; col++) {
                matrix[row][col]= matrix[row-1][col-1] + matrix[row-1][col];
            }
        }
        for (long[] ints : matrix) {
            for (long anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
