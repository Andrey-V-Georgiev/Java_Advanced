package _09_ObjectsClassesAPIsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _10_CountSymbols {
    static String input;
    static List<Character> allChars;
    static HashSet<Character> uniqueChars;
    static TreeMap<Character, Integer> frequenceMap;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        input = bf.readLine();
        allChars = new ArrayList<>();
        putInList();
        uniqueChars = new HashSet<>();
        putInSet();
        frequenceMap = new TreeMap<>();
        checkCharsFrequence();
        printTheMap();
    }

    private static void printTheMap() {
        for (Map.Entry<Character, Integer> entry : frequenceMap.entrySet()) {
           char currChar = entry.getKey();
           int currFrequence = entry.getValue();
            System.out.printf("%c: %d time/s%n",currChar , currFrequence);
        }
    }

    private static void checkCharsFrequence() {
        for (Character uniqueChar : uniqueChars) {
            int currFrequence = Collections.frequency(allChars, uniqueChar);
            frequenceMap.put(uniqueChar, currFrequence);
        }
    }

    private static void putInSet() {
        for (int i = 0; i < input.length(); i++) {
            uniqueChars.add(input.charAt(i));
        }
    }

    private static void putInList() {
        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);
            allChars.add(currChar);
        }
    }
}
