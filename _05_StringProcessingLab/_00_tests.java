package _05_StringProcessingLab;

import java.util.ArrayDeque;
import java.util.Deque;

public class _00_tests {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        System.out.println(deque.poll());
        System.out.println(deque.poll());
    }
}
