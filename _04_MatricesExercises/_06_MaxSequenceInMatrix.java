package _04_MatricesExercises;

import java.util.Scanner;

public class _06_MaxSequenceInMatrix {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        String[][] matrix = new String[rows][cols];
        int maxLength = 1;
        String maxString = "";

        //Read the input table
        for (int row = 0; row < rows; row++) {
            String[] scanLine = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanLine[col];
            }
        }

        //Check and find the longest sequence
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                //Check horizontal
             /*   int horizontalCounter = 1;
                for (int i = col; i < cols - 1; i++) {
                    if (matrix[row][i].equals(matrix[row][i + 1])) {
                        horizontalCounter++;
                        if (maxLength <= horizontalCounter) {
                            maxLength = horizontalCounter;
                            maxString = matrix[row][i];
                        }
                    } else {

                        break;
                    }
                }*/

                //Check vertical
                int verticalCounter = 1;
                for (int i = row; i < rows - 1; i++) {
                    if (matrix[i][col].equals(matrix[i + 1][col])) {
                        verticalCounter++;
                        if (maxLength <= verticalCounter) {
                            maxLength = verticalCounter;
                            maxString = matrix[i][col];
                        }
                    } else {
                        break;
                    }
                }

                //Check left diagonal
              /*  int leftDiagonalCounter = 1;
                int rowCoeffL = rows - row - 1;
                int colCoeffL = cols - col - 1;
                int iterationsL = Math.min(rowCoeffL, colCoeffL);
                if(iterationsL==0 && maxLength==1){
                    maxString= matrix[row][col];
                    continue;
                }

                int startRowL = row;
                int startColL = col;

                for (int k = 0; k < iterationsL; k++) {

                    if (matrix[startRowL][startColL].equals(matrix[startRowL + 1][startColL + 1])) {
                        leftDiagonalCounter++;
                        if (maxLength <= leftDiagonalCounter) {
                            maxLength = leftDiagonalCounter;
                            maxString = matrix[row][col];
                        }
                    } else {
                        break;
                    }
                    startRowL++;
                    startColL++;
                }*/

                //Check right diagonal
               /* int rightDiagonalCounter = 1;
                int rowCoeffR = rows - row - 1;
                int colCoeffR = col;
                int iterationsR = Math.min(rowCoeffR, colCoeffR);
                if(iterationsR==0 && maxLength==1){
                    maxString= matrix[row][col];
                    continue;
                }

                int startRowR = row;
                int startColR = col;
                for (int k = 0; k < iterationsR; k++) {

                    if (matrix[startRowR][startColR].equals(matrix[startRowR + 1][startColR - 1])) {
                        rightDiagonalCounter++;
                        if (maxLength <= rightDiagonalCounter) {
                            maxLength = rightDiagonalCounter;
                            maxString = matrix[row][col];
                        }
                    } else {
                        break;
                    }
                    startRowR++;
                    startColR--;
                }*/
            }
        }

        String output = "";
        for (int i = 0; i < maxLength; i++) {
            output += maxString + ", ";
        }
        System.out.println(output = output.substring(0, output.length()-2));
    }
}

