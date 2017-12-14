package _01_JavaSyntaxLab;

import java.util.Scanner;

public class _09_CalculateTriangleAreaMethod {
    public static void main(String[] args) {
        double result = CalculateArea();

        System.out.printf("Area = %.2f",result);
    }

    private static double CalculateArea() {
        Scanner scanner = new Scanner(System.in);
        double firstD = scanner.nextDouble();
        double secondD = scanner.nextDouble();

        double triangleArea = (firstD * secondD) /2;

        return triangleArea;
    }
}
