package _05_StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _04_DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.valueOf(scanner.nextLine()); //Turn input String to Integer

        ArrayDeque<Integer> stack = new ArrayDeque<>(); //Declare stack

        while (decimal != 0) { //Till decimal become zero
            stack.push(decimal % 2); //We push the rest in the stack
            decimal /= 2; //And divide decimal by integer division
        }
        if (stack.size() == 0) {      //If stack is empty we print zero
            System.out.println(0);

        } else {
            while (!stack.isEmpty()) { //We pop everything inside the stack and print it
                System.out.print(stack.pop());
            }
        }
    }
}
