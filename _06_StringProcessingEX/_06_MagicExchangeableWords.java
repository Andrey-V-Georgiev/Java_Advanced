package _06_StringProcessingEX;

import java.util.HashSet;
import java.util.Scanner;


public class _06_MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        HashSet<Character> firstWord = new HashSet<>();
        HashSet<Character> secondWord = new HashSet<>();

        for (int i = 0; i < input[0].length(); i++) {
            firstWord.add(input[0].charAt(i));
        }

        for (int i = 0; i < input[1].length(); i++) {
            secondWord.add(input[1].charAt(i));
        }

        if(firstWord.size()==secondWord.size()){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }
}
