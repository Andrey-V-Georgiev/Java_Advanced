package _01_JavaSyntaxLab;

import java.math.BigInteger;
import java.util.Scanner;

public class _07_ProductOfNumbers_NtoM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        BigInteger sum = BigInteger.valueOf(n);
        for (int i = n+1; i <= m ; i++) {
            BigInteger multiplier = BigInteger.valueOf(i);
            sum = sum.multiply( multiplier);
        }
        System.out.printf("product[%d..%d] = %d",n,m,sum);

    }
}
