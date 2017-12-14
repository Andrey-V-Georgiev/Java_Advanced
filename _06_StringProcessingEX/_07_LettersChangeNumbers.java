package _06_StringProcessingEX;

import java.util.Scanner;

public class _07_LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double sum = 0;

        for (String item : input) {

            char firstChar = item.charAt(0);
            char lastChar = item.charAt(item.length() - 1);
            String substringNum = item.substring(1, item.length() - 1);
            double num = Double.parseDouble(substringNum);

            num = checkTheFirstLetter(firstChar, num);
            num = checkTheLastLetter(lastChar, num);
            sum+=num;
        }

        System.out.printf("%.2f",sum);
    }

    private static double checkTheLastLetter(char lastChar, double num) {
        int position = findPosition(lastChar);
        if (Character.isUpperCase(lastChar)) {
            num -= position;
        } else {
            num += position;
        }
        return num;

    }

    private static double checkTheFirstLetter(char firstChar, double num) {
        int position = findPosition(firstChar);
        if (Character.isUpperCase(firstChar)) {
            num /= position;
        } else {
            num *= position;
        }
        return num;
    }

    private static int findPosition(char firstChar) {
        char currChar = Character.toLowerCase(firstChar);
        int position = 0;
        switch (currChar) {
            case 'a':
                position = 1;
                break;
            case 'b':
                position = 2;
                break;
            case 'c':
                position = 3;
                break;
            case 'd':
                position = 4;
                break;
            case 'e':
                position = 5;
                break;
            case 'f':
                position = 6;
                break;
            case 'g':
                position = 7;
                break;
            case 'h':
                position = 8;
                break;
            case 'i':
                position = 9;
                break;
            case 'j':
                position = 10;
                break;
            case 'k':
                position = 11;
                break;
            case 'l':
                position = 12;
                break;
            case 'm':
                position = 13;
                break;
            case 'n':
                position = 14;
                break;
            case 'o':
                position = 15;
                break;
            case 'p':
                position = 16;
                break;
            case 'q':
                position = 17;
                break;
            case 'r':
                position = 18;
                break;
            case 's':
                position = 19;
                break;
            case 't':
                position = 20;
                break;
            case 'u':
                position = 21;
                break;
            case 'v':
                position = 22;
                break;
            case 'w':
                position = 23;
                break;
            case 'x':
                position = 24;
                break;
            case 'y':
                position = 25;
                break;
            case 'z':
                position = 26;
                break;
        }
        return position;
    }
}
