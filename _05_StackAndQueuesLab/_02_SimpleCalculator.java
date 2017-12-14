package _05_StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class _02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+"); //Separate the input to array
        Deque<String> stack = new ArrayDeque<>(); //Declare new stack
        Collections.addAll(stack, tokens); //Fill da stack with the array

        while(stack.size() > 1){
            int first = Integer.valueOf(stack.pop());
            String op = stack.pop();
            int second = Integer.valueOf(stack.pop());

            switch (op){
                case "+": stack.push(String.valueOf(first + second));
                    break;
                case "-": stack.push(String.valueOf(first - second));
                    break;
            }

        }
        System.out.println(stack.pop());
    }
}
