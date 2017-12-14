package _03_AbstractionLab;

import java.util.Arrays;
import java.util.Scanner;

public class _04_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read the frame
        int[] frame = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = frame[0];
        int cols = frame[1];
        int[][] matrix = new int[rows][cols];

        //fill the matrix
        for (int row = 0; row < rows; row++) {
            int[] line = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col]= line[col];
            }
        }

        //check the max
        int maxSum = Integer.MIN_VALUE;
        int maxR = 0;
        int maxC = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                try {
                    int currSum = matrix[row][col]
                            + matrix[row][col + 1]
                            + matrix[row + 1][col]
                            + matrix[row + 1][col + 1];
                    if (currSum > maxSum) {
                        maxSum = currSum;
                        maxR = row;
                        maxC = col;
                    }
                }catch(Exception e){
                    continue;
                }
            }
        }

        System.out.print(matrix[maxR][maxC]+" ");
        System.out.println(matrix[maxR][maxC + 1]);
        System.out.print(matrix[maxR + 1][maxC]+" ");
        System.out.println(matrix[maxR + 1][maxC + 1]);
        System.out.println(maxSum);
    }
}
