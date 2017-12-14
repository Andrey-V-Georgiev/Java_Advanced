package _04_AbstractionEX;

import java.util.Scanner;

public class _01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");
        int n = Integer.parseInt(input[0].trim());
        char pattern = input[1].trim().charAt(0);

        switch (pattern) {
            case 'A':
                printPatternA(n);
                break;
            case 'B':
                printPatternB(n);
            default:
                break;
        }
    }

    private static void printPatternA(int n) {
        int[][] matrixA = createMatrixA(n);
        for (int row = 0; row < matrixA.length; row++) {
            for (int col = 0; col < matrixA[0].length; col++) {
                System.out.print(matrixA[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] createMatrixA(int n) {
        int[][] matrixA = new int[n][n];
        int counter = 1;
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                matrixA[row][col] = counter;
                counter++;
            }
        }
        return matrixA;
    }

    private static void printPatternB(int n) {
        int[][] matrixB = createMatrixB(n);
        for (int row = 0; row < matrixB.length; row++) {
            for (int col = 0; col < matrixB[0].length; col++) {
                System.out.print(matrixB[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] createMatrixB(int n) {
        int[][] matrixB = new int[n][n];
        int counter = 1;
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                if(col % 2 == 0){
                    matrixB[row][col] = counter;
                    counter++;
                } else {
                    matrixB[n-1-row][col] = counter;
                    counter++;
                }
            }
        }
        return matrixB;
    }

}
