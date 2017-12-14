package _05_StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");  //Read the input with the children's names
        int n = Integer.valueOf(scanner.nextLine());   //Value of n
        ArrayDeque<String> queue = new ArrayDeque<>();   //Declare the queue

        for (String child : children) {   //Fill the children in the queue
            queue.offer(child);
        }

        while(queue.size() > 1){  //Rotate till only one left
            for (int i = 1; i < n ; i++) {
                queue.offer(queue.poll());
            }
                System.out.println("Removed " + queue.poll());

        }

        System.out.println("Last is " + queue.poll());
    }
}
