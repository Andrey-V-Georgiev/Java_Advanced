package _09_ObjectsClassesAPIsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class _14_Stoqn {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, ArrayList<CityPopulation>> map = new LinkedHashMap<>();
        while (true) {
            String input = reader.readLine();
            if (input.equalsIgnoreCase("report")) {
                break;
            }
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);
            CityPopulation cp = new CityPopulation();
            cp.population = population;
            cp.city = city;
            if (map.containsKey(country)) {
                map.get(country).add(cp);
            } else {
                ArrayList<CityPopulation> cityPopulations = new ArrayList<>();
                cityPopulations.add(cp);
                map.put(country, cityPopulations);
            }
        }

        LinkedHashMap<String, Long> firstLines = calculateTotalPopulationAndReturn(map);
        LinkedHashMap<String, Long> resultTopLine = firstLines
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (String country:resultTopLine.keySet()) {
            System.out.printf("%s (total population: %d)\n", country, resultTopLine.get(country));
            map
                    .get(country)
                    .sort(Comparator.comparingLong(CityPopulation::getPopulation).reversed());

            for (CityPopulation cp : map.get(country)) {
                System.out.printf("=>%s: %d\n", cp.city, cp.population);
            }
        }
    }

    private static LinkedHashMap<String, Long> calculateTotalPopulationAndReturn(LinkedHashMap<String, ArrayList<CityPopulation>> map) {
        LinkedHashMap<String, Long> result = new LinkedHashMap<>();
        for (String country : map.keySet()) {
            long pop = 0;
            for (CityPopulation cp : map.get(country)) {
                pop += cp.population;
            }
            result.put(country, pop);
        }
        return result;
    }

    private static class CityPopulation {
        private String city;

        private long population;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public long getPopulation() {
            return population;
        }

        public void setPopulation(long population) {
            this.population = population;
        }
    }
}
