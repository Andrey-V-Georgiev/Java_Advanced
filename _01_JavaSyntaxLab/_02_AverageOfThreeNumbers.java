package _01_JavaSyntaxLab;

import java.util.Scanner;

public class _02_AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstDouble = scanner.nextDouble();
        double secondDouble = scanner.nextDouble();
        double thirdDouble = scanner.nextDouble();

        double sum = firstDouble + secondDouble + thirdDouble;
        double average = sum / 3;
        System.out.printf("%.2f",average);
    }
}
