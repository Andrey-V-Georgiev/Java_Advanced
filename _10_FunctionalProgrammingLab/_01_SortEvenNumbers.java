package _10_FunctionalProgrammingLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _01_SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> listNum = Stream.of(bf.readLine().split(", ")).map(String::trim)
                .map(Integer::valueOf).collect(Collectors.toList());

        Predicate<Integer> getEven = x -> x % 2 != 0;
        listNum.removeIf(getEven);
        System.out.println(String.valueOf(listNum).replace("[","").replace("]",""));

        Comparator<Integer> compare = (a, b) -> a.compareTo(b);
        Collections.sort(listNum, compare);

        System.out.println(String.valueOf(listNum).replace("[","").replace("]",""));

    }
}
