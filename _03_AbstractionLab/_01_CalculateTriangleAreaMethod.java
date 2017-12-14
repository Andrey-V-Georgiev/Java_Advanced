package _03_AbstractionLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class _01_CalculateTriangleAreaMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        double a = input[0];
        double b = input[1];
        double area = a*b/2;
        System.out.printf("Area = %.2f", area);
    }
}
