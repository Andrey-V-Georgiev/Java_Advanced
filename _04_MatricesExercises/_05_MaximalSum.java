package _04_MatricesExercises;

import java.util.Scanner;

public class _05_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];

        //Read the input and fill matrix
        for (int row = 0; row < rows; row++) {
            String[] scanLine = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(scanLine[col]);
            }
        }

        //Find the max sum
        int maxSum = 0;
        int maxRow = 0;
        int maxCol = 0;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int currSum = matrix[row][col] + matrix[row][col+1]+matrix[row][col+2]
                        + matrix[row+1][col] + matrix[row+1][col+1]+matrix[row+1][col+2]
                        + matrix[row+2][col] + matrix[row+2][col+1]+matrix[row+2][col+2];
                if(currSum>maxSum){
                    maxSum = currSum;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }

        //Print results
        System.out.printf("Sum = %d%n",maxSum);
        for (int row = maxRow; row < maxRow+3 ; row++) {
            for (int col = maxCol; col < maxCol+3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
