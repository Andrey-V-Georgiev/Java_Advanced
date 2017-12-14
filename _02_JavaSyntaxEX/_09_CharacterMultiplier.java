package _02_JavaSyntaxEX;

import java.util.Scanner;

public class _09_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");
        int firstLength = arr[0].length();
        int secondLength = arr[1].length();
        long sum = 0;

        String shortStr = firstLength <= secondLength ? arr[0] : arr[1];
        String longStr = firstLength > secondLength ? arr[0] : arr[1];

        for (int i = 0; i < longStr.length(); i++) {
            if (i < shortStr.length()) {
               sum+=((int)shortStr.charAt(i)) * ((int)longStr.charAt(i));
            } else {
                sum+= (int)longStr.charAt(i);
            }
        }
        System.out.println(sum);
    }
}
