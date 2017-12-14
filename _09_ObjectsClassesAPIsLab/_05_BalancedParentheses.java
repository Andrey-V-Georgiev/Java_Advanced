package _09_ObjectsClassesAPIsLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Deque<Character> leftQueue = new ArrayDeque<>();
        Deque<Character> rightStack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
           if(i<input.length()/2) {
               leftQueue.add(input.charAt(i));
           } else{
               rightStack.push(input.charAt(i));
           }
        }

        if(leftQueue.size()!=rightStack.size()){
            System.out.println("NO");
            return;
        }

        while(!leftQueue.isEmpty() && !rightStack.isEmpty()){
            char currLeft = leftQueue.poll();
            char currRight = rightStack.pop();

            int leftMark = 0;
            int rightMark = 0;
            switch (currLeft){
                case '{': leftMark = 1;break;
                case '[': leftMark = 2; break;
                case '(': leftMark = 3; break;
            }
            switch (currRight){
                case '}': rightMark = 1;break;
                case ']': rightMark = 2; break;
                case ')': rightMark = 3; break;
            }

            if(leftMark != rightMark){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}