package _11_FunctionalProgrammingEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _13_InfernoIII2 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numsList = Stream.of(bf.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        HashMap<String, Predicate<Integer>> predicatesForExclude = new HashMap<>();

        String[] commands = bf.readLine().split(";");
        while (!commands[0].equals("Forge")) {
            String action = commands[0];
            String searchedScope = commands[1];
            int searchedSum = Integer.parseInt(commands[2]);
            Predicate<Integer> condition = makePredicate (searchedScope, searchedSum, numsList);
            switch (action) {
                case "Exclude":
                    predicatesForExclude.put(searchedScope + searchedSum, condition);
                    break;
                case "Reverse":
                    predicatesForExclude.remove(searchedScope + searchedSum);
                    break;
            }
            commands = bf.readLine().split(";");
        }

        for (int i = 0; i < numsList.size(); i++) {
            boolean found = false;
            for(Predicate<Integer> predicate : predicatesForExclude.values()){
                if(predicate.test(i)){
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.print(numsList.get(i) + " ");
            }
        }
    }

    private static Predicate<Integer> makePredicate(String searchedScope, Integer searchedSum, List<Integer> numsList) {
        switch (searchedScope){
            case "Sum Left":
                return index -> (index > 0 ? numsList.get(index - 1) : 0) + numsList.get(index) == searchedSum;
            case "Sum Right":
                return index -> (index < numsList.size()-1 ? numsList.get(index + 1) : 0) + numsList.get(index) == searchedSum;
            default:
                return index -> (index > 0 ? numsList.get(index - 1) : 0) + numsList.get(index) +
                        (index < numsList.size()-1 ? numsList.get(index + 1) : 0) == searchedSum;
        }
    }

}
