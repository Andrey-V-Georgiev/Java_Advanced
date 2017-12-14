package _10_FunctionalProgrammingLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _05_FilterByAge {

    static String condition;
    static int ageBorder;
    static String format;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Integer> people = new LinkedHashMap();
        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            List<String> line = Stream.of(bf.readLine().split(", ")).collect(Collectors.toList());
            String name = line.get(0);
            int age = Integer.parseInt(line.get(1));
            people.put(name, age);
        }

        condition = bf.readLine();
        ageBorder = Integer.parseInt(bf.readLine());
        format = bf.readLine();

        BiFunction<Integer, Integer, Boolean> checkForBorder = (x, y) -> x <= y;

        printAfterFiltring(people, checkForBorder);
    }

    private static void printAfterFiltring(LinkedHashMap<String, Integer> people, BiFunction<Integer, Integer, Boolean> checkForBorder) {
        boolean ageRequirements = false;

        for (Map.Entry<String, Integer> person : people.entrySet()) {
            String name = person.getKey();
            int age = person.getValue();

            switch (condition) {
                case "older":
                    ageRequirements = checkForBorder.apply(ageBorder, people.get(person.getKey()));
                    break;
                case "younger":
                    ageRequirements = checkForBorder.apply(people.get(person.getKey()), ageBorder);
                    break;
            }
            if(ageRequirements) {
                switch (format) {
                    case "name age":
                        System.out.printf("%s - %d%n", name, age);
                        break;
                    case "name":
                        System.out.printf("%s%n", name);
                        break;
                    case "age":
                        System.out.printf("%d%n", age);
                        break;
                }
            }
        }
    }
}
