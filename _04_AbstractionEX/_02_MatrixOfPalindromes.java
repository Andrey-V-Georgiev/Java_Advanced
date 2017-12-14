package _04_AbstractionEX;

import java.util.Arrays;
import java.util.Scanner;

public class _02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();

        int rows = input[0];
        int cols = input[1];
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col]= producePalindrome(row, col);
            }
        }

        printPalindromeMatrix(matrix);
    }

    private static void printPalindromeMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static String producePalindrome(int row, int col) {
        char firstAndLast = (char) (row + 97);
        char middle = (char) (row + col + 97);
        StringBuilder palindrome = new StringBuilder().append(firstAndLast).append(middle).append(firstAndLast);
        return palindrome.toString();
    }
}
