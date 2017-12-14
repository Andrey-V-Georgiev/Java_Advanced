package _15_PrepI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class _01_Shockwave {
    static int[] rectangleDimensions;
    static List<int[]> wavesCoordinates = new ArrayList<>();
    static int[][] matrix;


    public static void main(String[] args) throws IOException {
        readTheInputData();
        fillTheMatrix();
        manipulateTheMatrix();
        printTheMatrix();
    }

    private static void printTheMatrix() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void manipulateTheMatrix() {
        for (int[] c : wavesCoordinates) {
            int x1 = c[0];
            int y1 = c[1];
            int x2 = c[2];
            int y2 = c[3];
            for (int row = x1; row <= x2; row++) {
                for (int col = y1; col <= y2; col++) {
                    matrix[row][col]++;
                }
            }
        }
    }

    private static void fillTheMatrix() {
        matrix = new int[rectangleDimensions[0]][rectangleDimensions[1]];
        for (int i = 0; i < rectangleDimensions[0]; i++) {
            for (int j = 0; j < rectangleDimensions[1]; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    private static void readTheInputData() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        rectangleDimensions = Stream.of(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String input = bf.readLine();

        while (!"Here We Go".equals(input)) {
            String[] line = input.split("\\s+");
            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            int x2 = Integer.parseInt(line[2]);
            int y2 = Integer.parseInt(line[3]);
            int[] currentCoordinates = new int[]{x1, y1, x2, y2};
            wavesCoordinates.add(currentCoordinates);

            input = bf.readLine();
        }
    }
}
