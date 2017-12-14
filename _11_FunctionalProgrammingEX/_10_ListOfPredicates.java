package _11_FunctionalProgrammingEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _10_ListOfPredicates {
    static BiPredicate<Integer, Integer> isDivisible;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Set<Integer> divisors = Stream.of(bf.readLine().split("\\s+")).map(Integer::valueOf)
                .filter(x -> x > 1).collect(Collectors.toSet());
        isDivisible = (x, y) -> x % y == 0;
        SortedSet<Integer> resultList = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            if (checkAllDivisors(divisors, i)) {
                resultList.add(i);
            }
        }

        System.out.println(resultList.toString()
                .toString().replace("[", "")
                .replace("]", "")
                .replace(",", ""));
    }

    private static boolean checkAllDivisors(Set<Integer> divisors, int i) {
        for (Integer divisor : divisors) {
            if(!isDivisible.test(i, divisor)){
                return false;
            }
        }
        return true;
    }
}
