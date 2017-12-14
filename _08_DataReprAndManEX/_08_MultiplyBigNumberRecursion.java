package _08_DataReprAndManEX;

import java.util.Scanner;

public class _08_MultiplyBigNumberRecursion {
    static String number;
    static int multiplier;
    static String sum;
    static int currRest;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringNum = scanner.nextLine();
        multiplier = Integer.parseInt(scanner.nextLine());
        sb = new StringBuilder();
        boolean isDash = stringNum.charAt(0) == '-';
        if (isDash) {
            number = stringNum.substring(1, stringNum.length());
            sum = multiplyNumbers(0);
            System.out.println("-" + sum);
        } else {
            number = stringNum;
            sum = multiplyNumbers(0);
            System.out.println(sum);
        }
    }


    private static String multiplyNumbers(int i) {
        StringBuilder num = new StringBuilder();
        num.append(number);
        int currN = num.charAt(num.length() - 1 - i) - 48;
        int currResult = (currN * multiplier) + currRest;
        currRest = currResult / 10;
        int currAdd = currResult % 10;
        sb.append(currAdd);
        if (i == num.length() - 1) {
            if (currRest != 0) {
                sb.append(currRest);
            }
            sb.reverse();
            return sb.toString();
        }
        return multiplyNumbers(i + 1);
    }
}
