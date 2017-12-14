package _05_StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _07_PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for (Character c : input.toCharArray()) {
                queue.offer(c);
        }

        boolean isPalindrome =  true;
        while(queue.size() > 1){
            char first = queue.pollLast();
            char last = queue.poll();
            if(first != last){
                isPalindrome=false;
                break;
            }
        }
        System.out.println(isPalindrome);
    }
}
