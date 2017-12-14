package _06_StackAndQueueExercises;

import java.util.*;

public class _04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] commands = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = commands[0];
        int s = commands[1];
        int x = commands[2];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.add(nums[i]);
        }
        for (int i = 0; i < s; i++) {
            queue.remove();
        }
        if(queue.contains(x)==true){
            System.out.println("true");
        }else if(queue.size()==0){
            System.out.println(0);
        }else{
            System.out.println(Collections.min(queue));
        }
        return;
    }
}
