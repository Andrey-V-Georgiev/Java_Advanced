package _09_ObjectsClassesAPIsLab;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class _15_LegendaryFarming60 {

    public static void main(String[] args) throws IOException {

        Map<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards" , 0);
        keyMaterials.put("fragments" , 0);
        keyMaterials.put("motes" , 0);
        Map<String, Integer> junkMaterials = new TreeMap<>();
        fillKeyMaterialsMap(keyMaterials, junkMaterials);

    }

    private static void sortAndPrintResults(Map<String, Integer> keyMaterials, Map<String, Integer> junkMaterials) {

        LinkedHashMap<String, Integer> sortedKeyMaterials = keyMaterials.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, Integer> pair : sortedKeyMaterials.entrySet()) {
            System.out.printf("%s: %d%n", pair.getKey(), pair.getValue());
        }

        for (Map.Entry<String, Integer> pair : junkMaterials.entrySet()) {
            System.out.printf("%s: %d%n", pair.getKey(), pair.getValue());
        }
    }

    private static void fillKeyMaterialsMap(Map<String, Integer> keyMaterials, Map<String, Integer> junkMaterials) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String regex = "(\\d+)\\s+(\\w+)";
        Pattern pattern = Pattern.compile(regex);
        String inputLine = scanner.nextLine().toLowerCase();

        while (!inputLine.equals("")) {

            Matcher matcher = pattern.matcher(inputLine);
            while (matcher.find()) {

                String nameCurrentResource = matcher.group(2);
                int currentResourceQuantity = Integer.parseInt(matcher.group(1));
                if (checkForKeyMaterial(nameCurrentResource)) {
                   if (keyMaterials.containsKey(nameCurrentResource)) {
                        keyMaterials.put(nameCurrentResource, keyMaterials.get(nameCurrentResource) + currentResourceQuantity);
                    } else {
                        keyMaterials.put(nameCurrentResource, currentResourceQuantity);
                   }
                    if (checkForWinner(keyMaterials)) {
                        keyMaterials.put(nameCurrentResource, keyMaterials.get(nameCurrentResource) - 250);
                        printWinner(nameCurrentResource);
                        sortAndPrintResults(keyMaterials, junkMaterials);
                        return;
                    }
                } else {
                    if (junkMaterials.containsKey(nameCurrentResource)) {
                        junkMaterials.put(nameCurrentResource, junkMaterials.get(nameCurrentResource) + currentResourceQuantity);
                    } else {
                        junkMaterials.put(nameCurrentResource, currentResourceQuantity);
                    }
                }
            }

            inputLine = scanner.nextLine().toLowerCase();
        }
        return;
    }

    private static boolean checkForKeyMaterial(String nameCurrentResource) {
        switch (nameCurrentResource) {
            case "shards":
                return true;
            case "fragments":
                return true;
            case "motes":
                return true;
            default:
                return false;
        }

    }

    private static void printWinner(String nameCurrentResource) {
        switch (nameCurrentResource) {
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
    }

    private static boolean checkForWinner(Map<String, Integer> keyMaterials) {

        if (keyMaterials.containsKey("shards")) {
            if (keyMaterials.get("shards") >= 250) {
                return true;
            }
        }
       if (keyMaterials.containsKey("fragments")) {
           if (keyMaterials.get("fragments") >= 250) {
               return true;
           }
       }
        if (keyMaterials.containsKey("motes")) {
            if (keyMaterials.get("motes") >= 250) {
                return true;
            }
        }
        return false;
    }
}
