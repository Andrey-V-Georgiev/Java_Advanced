package _02_JavaSyntaxEX;

import java.util.Scanner;

public class _04_CalculateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double numF1= (((a*a) + (b*b)) / ((a*a) - (b*b)));
        double powF1= (a + b + c) / Math.sqrt(c);
        double resultF1=Math.pow(numF1,powF1);

        double numF2= ((a*a)+(b*b)-(c*c*c));
        double powF2= (a - b);
        double resultF2=Math.pow(numF2,powF2);

        double avrNums= (a+b+c)/3;
        double avrF= (resultF1+resultF2)/2;
        double resultFinal= Math.abs(avrNums-avrF);
        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f",resultF1, resultF2, resultFinal);
    }
}
