package _05_StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_ReversingStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        ArrayDeque<Character> reversed =  new ArrayDeque<>();
        for(Character ch : inputString.toCharArray()){
            reversed.push(ch);
        }

        while(!reversed.isEmpty()){
            System.out.print(reversed.pop());
        }
    }
}
