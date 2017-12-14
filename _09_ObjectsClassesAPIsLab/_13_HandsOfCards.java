package _09_ObjectsClassesAPIsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _13_HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, HashSet<String>> mapCards = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> mapScores = new LinkedHashMap<>();

        String input = bf.readLine();
        while (!input.equals("JOKER")) {
            String[] inputArr = input.split(":");
            String name = inputArr[0];
            List<String> currCardsLine = Stream.of(inputArr[1].trim().split(", ")).collect(Collectors.toList());
            HashSet<String> cards = new HashSet<>(currCardsLine);
            if(!mapCards.containsKey(name)){
                mapCards.put(name, cards);
            }else{
                mapCards.get(name).addAll(cards);
            }
            input = bf.readLine();
        }
        for (Map.Entry<String, HashSet<String>> entry : mapCards.entrySet()) {
            String name = entry.getKey();
            int playerScore = findPlayerScore(entry.getValue());
            if(!mapScores.containsKey(name)){
                mapScores.put(name, playerScore);
            } else {
                mapScores.put(name, mapScores.get(name) + playerScore);
            }
        }
        printTheResults(mapScores);
    }

    private static void printTheResults(LinkedHashMap<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String name = entry.getKey();
            int score = entry.getValue();
            System.out.printf("%s: %d%n",name ,score );
        }
    }

    private static int findPlayerScore(HashSet<String> value) {
        int score = 0;
        for (String s : value) {
            int cardValue = findValue(s);
            score += cardValue;
        }
        return score;
    }

    private static int findValue(String s) {
        String power = s.substring(0, s.length()-1);
        String type = s.substring(s.length()-1, s.length());
        int valuePower = 0;
        int valueType = 0;

        switch (power) {
            case "2":
                valuePower = 2;
                break;
            case "3":
                valuePower = 3;
                break;
            case "4":
                valuePower = 4;
                break;
            case "5":
                valuePower = 5;
                break;
            case "6":
                valuePower = 6;
                break;
            case "7":
                valuePower = 7;
                break;
            case "8":
                valuePower = 8;
                break;
            case "9":
                valuePower = 9;
                break;
            case "10":
                valuePower = 10;
                break;
            case "J":
                valuePower = 11;
                break;
            case "Q":
                valuePower = 12;
                break;
            case "K":
                valuePower = 13;
                break;
            case "A":
                valuePower = 14;
                break;
        }
        switch (type) {
            case "S":
                valueType = 4;
                break;
            case "H":
                valueType = 3;
                break;
            case "D":
                valueType = 2;
                break;
            case "C":
                valueType = 1;
                break;
        }
        return valuePower * valueType;
    }
}
