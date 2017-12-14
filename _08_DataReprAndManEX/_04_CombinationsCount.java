package _08_DataReprAndManEX;

import java.util.Scanner;

public class _04_CombinationsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n = Double.parseDouble(scanner.nextLine());
        double k = Double.parseDouble(scanner.nextLine());

        double factorielN = factorial(n);
        double factorielK = factorial(k);
        double factorielNsubK = factorial(n-k);
        double result = factorielN / ((factorielNsubK) * factorielK);
        System.out.printf("%.0f", result);
    }

    private static double factorial(double n) {
        if( n <= 1){
            return 1;
        }
        return n * factorial(n - 1);
    }
}
