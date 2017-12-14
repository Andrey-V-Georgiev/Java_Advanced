package _09_ObjectsClassesAPIsLab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _12_A_MinerTask {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        String input = scanner.nextLine();
        String currResource = "";
        int currQuantity = 0;

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (input.equals("stop")) {
                break;
            }
            if (i % 2 == 0) {
                currResource = input;
            } else {
                currQuantity = Integer.parseInt(input);

                if (map.containsKey(currResource)) {
                    //map.replace(currResource, map.get(currResource), map.get(currResource) + currQuantity);
                    map.put(currResource, map.get(currResource) +currQuantity);
                } else {
                    map.put(currResource, currQuantity);
                }
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String currR = entry.getKey();
            int currQ = entry.getValue();
            System.out.printf("%s -> %d%n", currR, currQ);
        }
    }
}
