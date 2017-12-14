package _11_FunctionalProgrammingEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _11_PredicateParty {
    static BiPredicate<String, String> startsWith;
    static BiPredicate<String, String> endsWith;
    static BiPredicate<String, String> lengthIs;
    static String action;
    static String command;
    static String condition;
    static List<String> namesList;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        namesList = Stream.of(bf.readLine().split("\\s+")).collect(Collectors.toList());
        startsWith = (x, y) -> x.startsWith(y);
        endsWith = (x, y) -> x.endsWith(y);
        lengthIs = (x, y) -> x.length() == Integer.parseInt(y);

        String currLine = bf.readLine();
        while (!currLine.equals("Party!")) {
            action = currLine.split(" ")[0];
            command = currLine.split(" ")[1];
            condition = currLine.split(" ")[2];

            switch (action) {
                case "Double":
                    findAndDouble(condition, command);
                    break;
                case "Remove":
                    findAndRemove(condition, command);
                    break;
            }
            currLine = bf.readLine();
        }

        Stream.of(namesList).filter(x -> !x.equals("")).collect(Collectors.toList());
        String outputList = namesList.toString().toString().replace("[", "").replace("]", "");
        if (namesList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.printf("%s are going to the party!", outputList);

        }
    }

    private static void findAndRemove(String condition, String command) {
        for (int i = 0; i < namesList.size(); i++) {
            switch (command) {
                case "StartsWith":
                    if (startsWith.test(namesList.get(i), condition)) {
                        int nameIndex = namesList.indexOf(namesList.get(i));
                        namesList.remove(nameIndex);
                        i--;
                    }
                    break;
                case "EndsWith":
                    if (endsWith.test(namesList.get(i), condition)) {
                        int nameIndex = namesList.indexOf(namesList.get(i));
                        namesList.remove(nameIndex);
                        i--;
                    }
                    break;
                case "Length":
                    if (lengthIs.test(namesList.get(i), condition)) {
                        int nameIndex = namesList.indexOf(namesList.get(i));
                        namesList.remove(nameIndex);
                        i--;
                    }
                    break;
            }
        }
    }

    private static void findAndDouble(String condition, String command) {
        for (int i = 0; i < namesList.size(); i++) {
            switch (command) {
                case "StartsWith":
                    if (startsWith.test(namesList.get(i), condition)) {
                        int nameIndex = namesList.indexOf(namesList.get(i));
                        namesList.add(nameIndex + 1, namesList.get(i));
                        i++;
                    }
                    break;
                case "EndsWith":
                    if (endsWith.test(namesList.get(i), condition)) {
                        int nameIndex = namesList.indexOf(namesList.get(i));
                        namesList.add(nameIndex + 1, namesList.get(i));
                        i++;
                    }
                    break;
                case "Length":
                    if (lengthIs.test(namesList.get(i), condition)) {
                        int nameIndex = namesList.indexOf(namesList.get(i));
                        namesList.add(nameIndex + 1, namesList.get(i));
                        i++;
                    }
                    break;
            }
        }
    }
}
