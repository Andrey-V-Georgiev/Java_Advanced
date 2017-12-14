package _08_DataReprAndManEX;

import java.util.Scanner;

public class _08_MultiplyBigNumbersIterative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringNumberInput = scanner.nextLine();
        int intMultiplier = Integer.parseInt(scanner.nextLine());
        boolean isNegative = stringNumberInput.charAt(0) == '-';
        String stringNumber = stringNumberInput;
        if(isNegative){
            stringNumber = stringNumberInput.substring(1, stringNumberInput.length());
        }
        StringBuilder numberSB = new StringBuilder(stringNumber);
        StringBuilder result = new StringBuilder();
        numberSB.reverse();
        int currRest = 0;
        for (int i = 0; i < numberSB.length(); i++) {
            int currDigit = numberSB.charAt(i) - 48;
            int currResult = currRest + (currDigit * intMultiplier);
            int digitForAdd = currResult % 10;
            currRest = currResult / 10;
            result.append(digitForAdd);
        }
        if(currRest!=0){
            result.append(currRest);
        }
        if(isNegative){
            result.append('-');
        }
        result.reverse();
        System.out.println(result);

    }
}
