package _06_StringProcessingEX;

import java.util.Scanner;

public class _02_SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb1 = new StringBuilder(scanner.nextLine());
        StringBuilder sb2 = new StringBuilder(scanner.nextLine());

        int lengthDiff = Math.abs(sb1.length() - sb2.length());

        StringBuilder longer = sb1.length() < sb2.length() ? sb2 : sb1;
        StringBuilder shorter = sb1.length() >= sb2.length() ? sb2 : sb1;
        StringBuilder sum = new StringBuilder();
        longer.reverse();
        shorter.reverse();

        for (int i = 0; i < lengthDiff; i++) {
            shorter.append(0);
        }

        int rest = 0;
        int currIndexValue = 0;

        for (int i = 0; i < longer.length(); i++) {

            int intLonger = longer.charAt(i) - 48;
            int intShorter = shorter.charAt(i) - 48;
            int currentSum = intLonger + intShorter + rest;
            rest = currentSum / 10;
            currIndexValue = currentSum % 10;
            sum.append(currIndexValue);
        }
        if (rest != 0) {
            sum.append(rest);
        }
        sum.reverse();
        System.out.println(sum);

    }
}
