package _06_StackAndQueueExercises;

import java.util.*;

public class _03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsCount = Integer.parseInt(scanner.nextLine());
        Deque<Integer> someNumbers = new ArrayDeque<>();
        Deque<Integer> maxNumbers = new ArrayDeque<>();
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < commandsCount ; i++) {

            String[] commands = scanner.nextLine().split(" ");
            int command = Integer.parseInt(commands[0]);

            switch (command){
                case 1:
                    int number = Integer.parseInt(commands[1]);
                    if(number>=maxValue){
                        maxValue = number;
                        maxNumbers.push(maxValue);
                    }
                    someNumbers.push(number);
                    break;
                case 2:
                    int deletedItems = someNumbers.pop();
                    if(deletedItems == maxValue){
                        maxNumbers.pop();
                        if(!maxNumbers.isEmpty()){
                            maxValue = maxNumbers.peek();
                        }else{
                            maxValue = Integer.MIN_VALUE;
                        }
                    }
                    break;
                case 3:
                    System.out.println(maxNumbers.peek());
                    break;

            }

        }
    }
}
