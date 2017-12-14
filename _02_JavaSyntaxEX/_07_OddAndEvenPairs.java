package _02_JavaSyntaxEX;

import java.util.Arrays;
import java.util.Scanner;

public class _07_OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrNums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (arrNums.length % 2 != 0) {

            System.out.println("invalid length");
            return;

        } else {

            for (int i = 0; i < arrNums.length - 1; i += 2) {
                int num1 = arrNums[i];
                int num2 = arrNums[i + 1];

                boolean num1Even = num1 % 2 == 0;
                boolean num2Even = num2 % 2 == 0;

                if (num1Even && num2Even) {
                    System.out.printf("%d, %d -> both are even%n", num1, num2);
                }
                else if(!num1Even && !num2Even){
                    System.out.printf("%d, %d -> both are odd%n", num1, num2);
                }
                else {
                    System.out.printf("%d, %d -> different%n", num1, num2);
                }
            }
        }
    }
}
