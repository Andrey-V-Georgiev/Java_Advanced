package _04_AbstractionEX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _10_PlusRemove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputList = new ArrayList<>();
        inputList = fillTheList(scanner, inputList);
        char[][] matrixNormalCase = new char[inputList.size()][];
        char[][] matrixForChecking = new char[inputList.size()][];
        matrixNormalCase = fillTheNormalCaseMatrix(matrixNormalCase, inputList);
        matrixForChecking = fillCheckingMatrix(matrixNormalCase, matrixForChecking);
        matrixNormalCase = checkForMatches(matrixForChecking, matrixNormalCase);
        printmatrixNormalCase(matrixNormalCase);
    }

    private static void printmatrixNormalCase(char[][] matrixNormalCase) {
        for (int row = 0; row < matrixNormalCase.length; row++) {
            int cols = matrixNormalCase[row].length;
            for (int col = 0; col < cols; col++) {
                if (matrixNormalCase[row][col] != 0) {
                    System.out.print(matrixNormalCase[row][col]);
                }
            }
            System.out.println();
        }
    }

    private static char[][] checkForMatches(char[][] matrixForChecking, char[][] matrixNormalCase) {
        for (int row = 0; row < matrixNormalCase.length - 2; row++) {
            int cols = matrixNormalCase[row].length;
            for (int col = 0; col < cols; col++) {
                try {
                    if (
                            matrixForChecking[row][col] == matrixForChecking[row + 1][col]
                                    && matrixForChecking[row + 1][col] == matrixForChecking[row + 1][col - 1]
                                    && matrixForChecking[row + 1][col - 1] == matrixForChecking[row + 1][col + 1]
                                    && matrixForChecking[row + 1][col] == matrixForChecking[row + 2][col]) {
                        matrixNormalCase[row][col] = '\0';
                        matrixNormalCase[row + 1][col - 1] = '\0';
                        matrixNormalCase[row + 1][col] = '\0';
                        matrixNormalCase[row + 1][col + 1] = '\0';
                        matrixNormalCase[row + 2][col] = '\0';
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        }
        return matrixNormalCase;
    }

    private static char[][] fillCheckingMatrix(char[][] matrixNormalCase, char[][] matrixForChecking) {
        for (int row = 0; row < matrixNormalCase.length; row++) {
            int lineLength = matrixNormalCase[row].length;
            matrixForChecking[row] = new char[lineLength];
            for (int col = 0; col < lineLength; col++) {

                matrixForChecking[row][col] = Character.toLowerCase(matrixNormalCase[row][col]);
            }
        }
        return matrixForChecking;
    }

    private static char[][] fillTheNormalCaseMatrix(char[][] matrixNormalCase, List<String> inputList) {
        for (int row = 0; row < inputList.size(); row++) {
            String line = inputList.get(row);
            matrixNormalCase[row] = new char[line.length()];
            for (int col = 0; col < line.length(); col++) {
                matrixNormalCase[row][col] = line.charAt(col);
            }
        }
        return matrixNormalCase;
    }

    private static List<String> fillTheList(Scanner scanner, List<String> inputList) {
        String line = scanner.nextLine().trim();
        while (!line.equals("END")) {
            inputList.add(line);
            line = scanner.nextLine().trim();
        }
        return inputList;
    }
}
