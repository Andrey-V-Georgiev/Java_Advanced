package _03_AbstractionLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _03_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] frame = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = frame[0];
        int cols = frame[1];

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] line  = scanner.nextLine().split(",\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col]= Integer.parseInt(line[col].trim());
            }
        }

        long sum = 0;
        for (int[] rol : matrix) {
            for (int col : rol) {
                sum += col;
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
