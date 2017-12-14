package _04_AbstractionEX;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

public class _11_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int degree = getDegree(scanner);
        char[][] matrix = fillTheMatrix(scanner);
        matrix = rotateMatrix(matrix, degree);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static char[][] rotateMatrix(char[][] matrix, int degree) {
        int rotationPosition = findRotationPosition(degree);
        switch (rotationPosition) {
            case 0:
                matrix = rotateZero(matrix);
                break;
            case 90:
                matrix = rotate90(matrix);
                break;
            case 180:
                matrix = rotate180(matrix);
                break;
            case 270:
                matrix = rotate270(matrix);
                break;
        }
        return matrix;
    }

    private static char[][] rotate180(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[][] matrix180 = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix180[rows - 1 -row][cols-1-col] = matrix[row][col];
            }
        }
        return matrix180;
    }

    private static char[][] rotate270(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[][] matrix270 = new char[cols][rows];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix270[cols-1-col][row] = matrix[row][col];
            }
        }
        return matrix270;
    }

    private static char[][] rotate90(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[][] matrix90 = new char[cols][rows];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix90[col][rows-1-row] = matrix[row][col];
            }
        }
        return matrix90;
    }

    private static char[][] rotateZero(char[][] matrix) {
        return matrix;
    }

    private static int findRotationPosition(int degree) { //810
        int degreePosition = degree / 90; //9
        int rotationPosition = degreePosition % 4; //1
        int direction = 0;
        switch (rotationPosition) {
            case 0:
                direction = 0;
                break;
            case 1:
                direction = 90;
                break;
            case 2:
                direction = 180;
                break;
            case 3:
                direction = 270;
                break;
        }
        return direction;
    }

    private static char[][] fillTheMatrix(Scanner scanner) {
        List<String> lines = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            lines.add(input);
            input = scanner.nextLine();
        }
        int longestWord = findLongestWord(lines);
        int rows = lines.size();
        int cols = longestWord;
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String currLine = lines.get(row);
            for (int col = 0; col < cols; col++) {
                try {
                    matrix[row][col] = currLine.charAt(col);
                } catch (Exception e) {
                    matrix[row][col] = ' ';
                }
            }
        }
        return matrix;
    }

    private static int findLongestWord(List<String> lines) {
        int longest = 0;
        for (String line : lines) {
            if (line.length() > longest) {
                longest = line.length();
            }
        }
        return longest;
    }

    private static int getDegree(Scanner scanner) {
        String[] input = scanner.nextLine().split("[()]");
        int degree = Integer.parseInt(input[1]);
        return degree;
    }
}
