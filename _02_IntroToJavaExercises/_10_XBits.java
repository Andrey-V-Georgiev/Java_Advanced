package _02_IntroToJavaExercises;

import java.util.Scanner;

public class _10_XBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[8][];

        for (int i = 0; i < 8; i++) {
            int currNum = Integer.parseInt(scanner.nextLine());
            String binary = Integer.toBinaryString(currNum);
            String binaryPadded = String.format("%32s", binary).replace(' ', '0');
            char[] binaryToCharArr = binaryPadded.toCharArray();
            int[] numsArr = new int[32];
            for (int j = 0; j < 32; j++) {
                numsArr[j] = binaryToCharArr[j] - 48;
            }
            matrix[i] = numsArr;
        }

        int counter = 0;
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 31; j++) {
                if (matrix[i - 1][j - 1] == 1 && matrix[i - 1][j] == 0 && matrix[i - 1][j + 1] == 1
                        && matrix[i][j - 1] == 0 && matrix[i][j] == 1 && matrix[i][j + 1] == 0
                        && matrix[i + 1][j - 1] == 1 && matrix[i + 1][j] == 0 && matrix[i + 1][j + 1] == 1
                        ) {
                        counter++;
                }
            }
        }

        System.out.println(counter);
    }
}
