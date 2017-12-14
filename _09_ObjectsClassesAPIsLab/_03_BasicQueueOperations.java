package _09_ObjectsClassesAPIsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _03_BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] commands = Stream.of(bf.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int addCount = commands[0];
        int pollCount = commands[1];
        int numX = commands[2];

        List<Integer> nums = Stream.of(bf.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        Deque<Integer> queue = new ArrayDeque<>();
        addTheQueue(queue, addCount, nums);
        pollTheQueue(queue, pollCount);

        boolean isPresent = queue.contains(numX);
        if(isPresent){
            System.out.println("true");
        } else if(queue.isEmpty()) {
            System.out.println(0);
            return;
        } else {
            System.out.println( findTheSmallestElement(queue));
        }
    }

    private static int findTheSmallestElement(Deque<Integer> queue) {
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < queue.size(); i++) {
            int currNum = queue.poll();
            if(currNum < smallest){
                smallest = currNum;
            }
            queue.add(currNum);
        }
        return smallest;
    }

    private static void pollTheQueue(Deque<Integer> queue, int pollCount) {
        for (int i = 0; i < pollCount; i++) {
            queue.poll();
        }
    }

    private static void addTheQueue(Deque<Integer> queue, int addCount, List<Integer> nums) {
        for (int i = 0; i < addCount; i++) {
            queue.add(nums.get(i));
        }
    }
}
