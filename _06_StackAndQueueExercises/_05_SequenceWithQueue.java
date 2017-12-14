package _06_StackAndQueueExercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _05_SequenceWithQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = Long.parseLong(scanner.nextLine());

        Deque<Long> queue = new ArrayDeque<>();
        queue.add(n);

        for (int i = 0; i < 50; i++) {

            long s1 = queue.pop();
            long s2 = s1 + 1;
            long s3 = 2 * s1 + 1;
            long s4 = s1 + 2;
            queue.offer(s2);
            queue.offer(s3);
            queue.offer(s4);

            System.out.printf("%d ", s1);
        }
    }
}
