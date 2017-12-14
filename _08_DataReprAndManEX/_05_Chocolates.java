package _08_DataReprAndManEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _05_Chocolates {
    static int n;
    static int[] packs;
    static int m;
    static List<Integer> allDiff;
    static int[] packCombinations;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine().trim());
        packs = Stream.of(bf.readLine().split(", ")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        m = Integer.parseInt(bf.readLine().trim());
        packCombinations = new int[m];
        allDiff = new ArrayList<>();
        allCombinations(0);
        findMinDiff();
    }

    private static void findMinDiff() {
        allDiff = allDiff.stream().sorted((a,b)-> a.compareTo(b)).collect(Collectors.toList());
        int min = allDiff.get(0);
        System.out.printf("Min Difference is %d.", min);
    }

    public static void allCombinations(int currIndex) {
        if (currIndex == m) {
            fillDiffList();
            return;
        }
        for (int i = 0; i < packs.length; i++) {
            packCombinations[currIndex] = packs[i];
            allCombinations(currIndex + 1);
        }
    }

    private static void fillDiffList() {
        if(repeated()){
            return;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < packCombinations.length; i++) {
            if (packCombinations[i] < min) {
                min = packCombinations[i];
            }
            if (packCombinations[i] > max) {
                max = packCombinations[i];
            }
        }
        int diff = max - min;
        allDiff.add(diff);
    }

    private static boolean repeated() {
        try {
            List<Integer> checkList = Arrays.stream(packs).boxed().collect(Collectors.toList());
            for (int digit : packCombinations) {
                int indexForDelete = checkList.indexOf(digit);
                checkList.remove(indexForDelete);
            }
        }catch(Exception e){
            return true;
        }
        return false;
    }
}
