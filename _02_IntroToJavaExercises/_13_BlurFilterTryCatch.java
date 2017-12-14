package _02_IntroToJavaExercises;
import java.util.Arrays;
import java.util.Scanner;

public class _13_BlurFilterTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int blurWeight = Integer.parseInt(scanner.nextLine());
        int[] rowsCols = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[][] matrix = new long[rowsCols[0]][rowsCols[1]];

        for (int i = 0; i < rowsCols[0]; i++) {

            int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < rowsCols[1]; j++) {
                matrix[i][j] = input[j];
            }
        }

        int[] target = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = target[0] - 1; i <= target[0] + 1; i++) {
            for (int j = target[1] - 1; j <= target[1] + 1; j++) {
                try {
                    matrix[i][j] += blurWeight;
                } catch (Exception e) {
                    continue;
                }
            }
        }

        for (long[] row : matrix) {
            for (long j : row) {
                System.out.print(j + " ");
            }

            System.out.println("");
        }
    }
}
