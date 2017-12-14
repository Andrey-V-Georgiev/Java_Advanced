package _09_ObjectsClassesAPIsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class _14_Iv4o {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, HashMap<String, Long>> populationStrore = new HashMap<>();

        String[] input = reader.readLine().split("\\|");

        while (!input[0].equals("report")) {

            String country = input[1];
            String city = input[0];
            Long population = Long.parseLong(input[2]);

            populationStrore.putIfAbsent(country, new LinkedHashMap<>());
            populationStrore.get(country).putIfAbsent(city, population);

            input = reader.readLine().split("\\|");
        }
        LinkedHashMap<String, Long> result = new LinkedHashMap<>();

        for (String s : populationStrore.keySet()) {
            LinkedHashMap<String, Long> sorted = populationStrore.get(s).entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            Long totalPopulation = 0L;
            String towns = "";
            for (String s1 : sorted.keySet()) {
                Long townPop = populationStrore.get(s).get(s1);
                totalPopulation += townPop;
                towns += "=>" + s1 + ": " + townPop + "\n";
            }
            towns = s + " (total population: " + totalPopulation + ")" + "\n" + towns.substring(0, towns.length() - 1);
            result.put(towns, totalPopulation);

        }

        LinkedHashMap<String, Long> sorted = result.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (String s : sorted.keySet()) {
            System.out.println(s);
        }
    }
}
