package _02_JavaSyntaxEX;

import java.util.Scanner;

public class _02_TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double aX = scanner.nextDouble();
        double aY = scanner.nextDouble();
        double bX = scanner.nextDouble();
        double bY = scanner.nextDouble();
        double cX = scanner.nextDouble();
        double cY = scanner.nextDouble();

        double area =((aX*(bY-cY))+(bX*(cY-aY))+(cX*(aY-bY)))/2.0;
        System.out.println((int)Math.abs(area));
    }
}
