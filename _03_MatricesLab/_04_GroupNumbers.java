package _03_MatricesLab;
import java.util.Arrays;
import java.util.Scanner;

public class _04_GroupNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(
                scanner.nextLine()
                        .split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] lengthRow = new int[3];
        int[] indexByRow = new int[3];

        for (int number : numbers) {
            int rest = Math.abs(number) % 3;
            lengthRow[rest]++;
        }

        String[][] matrix = {new String[lengthRow[0]]
                , new String[lengthRow[1]]
                , new String[lengthRow[2]]};

        for (int number : numbers) {
            int row = Math.abs(number) % 3;
            int col = indexByRow[row];
            matrix[row][col] = Integer.toString(number);
            indexByRow[row]++;
        }

        System.out.println(String.join(" ",matrix[0]));
        System.out.println(String.join(" ",matrix[1]));
        System.out.println(String.join(" ",matrix[2]));
    }
}
