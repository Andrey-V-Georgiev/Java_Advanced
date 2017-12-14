package _12_StreamAPI_Lab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class _07_MapDistricts {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, List<Integer>> cities = new HashMap<>();
        String[] tokens = scanner.nextLine().split("\\s+");
        int limit = Integer.parseInt(scanner.nextLine());

        for (String token : tokens) {
            String[] cityArgs = token.split(":");
            String cityName = cityArgs[0];
            int districtPopulation = Integer.parseInt(cityArgs[1]);

            cities.putIfAbsent(cityName, new ArrayList<>());
            cities.get(cityName).add(districtPopulation);
        }

        cities.entrySet().stream()
            .filter(c -> c.getValue().stream().mapToInt(Integer::valueOf).sum() > limit)
                .sorted((e1, e2) -> Integer.compare(
                       e2.getValue().stream().mapToInt(Integer::valueOf).sum(),
                       e1.getValue().stream().mapToInt(Integer::valueOf).sum()  ))
                .forEach(e -> {
                    System.out.printf("%s: ", e.getKey());
                    e.getValue().stream()
                            .sorted((n1, n2)-> Integer.compare(n2, n1))
                            .limit(5)
                            .forEach(d -> System.out.print(d + " "));
                    System.out.println();
                    });

    }
}
