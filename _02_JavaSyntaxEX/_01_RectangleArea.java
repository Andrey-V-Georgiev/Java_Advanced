package _02_JavaSyntaxEX;

import java.util.Scanner;

public class _01_RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstD= scanner.nextDouble();
        double secondD= scanner.nextDouble();
        double area= firstD * secondD;
        System.out.printf("%.2f",area);
    }
}
