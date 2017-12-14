package _11_FunctionalProgrammingEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _13_InfernoIII80 {
    static List<Integer> initialList;
    static List<Integer> filteredIndexes;
    static Predicate<Integer> currPredicate;
    static String addOrRemove;
    static String checkScope;
    static int sumForCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        initialList = Stream.of(bf.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        filteredIndexes = new ArrayList<>();

        String receiveCommands = bf.readLine();
        while (!receiveCommands.equals("Forge")) {
            addOrRemove = receiveCommands.split(";")[0];
            checkScope = receiveCommands.split(";")[1];
            sumForCheck = Integer.parseInt(receiveCommands.split(";")[2]);
            currPredicate = usePredicate();
            switch (addOrRemove) {
                case "Exclude":
                    addFilteredIndexex();
                    break;
                case "Reverse":
                    filteredIndexes.removeIf(currPredicate);
                    break;
            }

            receiveCommands = bf.readLine();
        }
        printIndexes();
    }

    private static void printIndexes() {
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < filteredIndexes.size(); i++) {
            tempList.add(initialList.get(filteredIndexes.get(i)));
        }
        initialList.removeAll(tempList);
        System.out.println(initialList.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
        );
    }

    private static void addFilteredIndexex() {
        for (int i = 0; i < initialList.size(); i++) {
            if(currPredicate.test(i)){
                filteredIndexes.add(i);
            }
        }
    }

    private static Predicate<Integer> usePredicate() {
        switch (checkScope) {
            case "Sum Left":
                Predicate<Integer> sumLeft = (i) -> {
                    int sum = 0;
                    if (i == 0) {
                        sum = initialList.get(i);
                    } else {
                        sum = initialList.get(i - 1) + initialList.get(i);
                    }
                    return sum == sumForCheck;
                };
                return sumLeft;

            case "Sum Right":
                Predicate<Integer> sumRight = (i) -> {
                    int sum = 0;
                    if (i == initialList.size() - 1) {
                        sum = initialList.get(i);
                    } else {
                        sum = initialList.get(i) + initialList.get(i + 1);
                    }
                    return sum == sumForCheck;
                };
                return sumRight;

            default:
                Predicate<Integer> sumLeftRight = (i) -> {
                    int sum = 0;
                    if (i == 0) {
                        sum = initialList.get(i) + initialList.get(i + 1);
                    } else if (i == initialList.size() - 1) {
                        sum = initialList.get(i - 1) + initialList.get(i);
                    } else {
                        sum = initialList.get(i - 1) + initialList.get(i) + initialList.get(i + 1);
                    }
                    return sum == sumForCheck;
                };
                return sumLeftRight;
        }
    }
}
