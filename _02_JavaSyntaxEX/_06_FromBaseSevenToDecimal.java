package _02_JavaSyntaxEX;

import java.util.ArrayList;
import java.util.Scanner;

public class _06_FromBaseSevenToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        String numToStr = Integer.toString(number);
        int lastNum = 0;
        int base7 = 0;
        ArrayList<Integer> base10 = new ArrayList<>();

        for (int i = 0; i < numToStr.length(); i++) {
            lastNum = number % 10;
            base10.add(0, lastNum);
            number = number / 10;
        }

        int counter=0;
        for (int i = base10.size() - 1; i >= 0; i--) {
            base7+=base10.get(i) * Math.pow(7,counter);
            counter++;
        }

        System.out.println(base7);
    }
}
