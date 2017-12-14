package _09_ObjectsClassesAPIsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class _15_LegendaryFarming2 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> keyMap = new TreeMap<>();
        Map<String, Integer> junkMap = new TreeMap<>();

        keyMap.put("shards", 0);
        keyMap.put("fragments", 0);
        keyMap.put("motes", 0);

        String[] readLine = bf.readLine().split("\\s+");
        while (!readLine[0].equals("")) {

            for (int i = 0; i < readLine.length; i += 2) {

                int count = Integer.parseInt(readLine[0]);
                String name = readLine[1];

                if (name.equals("shards") || name.equals("fragments") || name.equals("motes")) {
                    if (keyMap.containsKey(name)) {
                        keyMap.replace(name, keyMap.get(name) + count);
                    } else {
                        keyMap.put(name, count);
                    }
                    if (keyMap.get(name) >= 250) {
                        print(name,keyMap , junkMap);
                    }
                } else {
                    if (junkMap.containsKey(name)) {
                        junkMap.replace(name, junkMap.get(name) + count);
                    } else {
                        junkMap.put(name, count);
                    }
                }
            }

            readLine = bf.readLine().split("\\s+");
        }
    }

    private static void print(String name, Map<String, Integer> keyMap, Map<String, Integer> junkMap) {
        keyMap.replace(name, keyMap.get(name) - 250);
        switch (name) {
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
        }

        LinkedHashMap<String, Integer> sortedKeyMaterials = keyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, Integer> pair : sortedKeyMaterials.entrySet()) {
            System.out.printf("%s: %d%n", pair.getKey(), pair.getValue());
        }

        for (Map.Entry<String, Integer> pair : junkMap.entrySet()) {
            System.out.printf("%s: %d%n", pair.getKey(), pair.getValue());
        }
        return;
    }
}
