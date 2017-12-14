package _01_IntroToJavaLab;

import java.util.Scanner;

public class _09_ExtractBitFromInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int p = Integer.parseInt(input[1]);

        String nToBinary = Integer.toBinaryString(n);
        try {
        char outputChar = nToBinary.charAt(nToBinary.length() - 1 - p);

            System.out.println(outputChar);
        }catch(Exception e){
            System.out.println(0);
        }
    }
}
