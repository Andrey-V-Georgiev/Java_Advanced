package _07_DataRepAndManLab;

import java.util.Scanner;

public class _04_RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Long.parseLong(scanner.nextLine());
        long output = factorial(n);
        System.out.println(output);
    }

    private static long factorial(long n) {
       if( n <= 1){
           return 1;
       }
       return n * factorial(n - 1);
    }
}
