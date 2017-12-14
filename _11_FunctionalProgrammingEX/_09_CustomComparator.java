package _11_FunctionalProgrammingEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _09_CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums = Stream.of(bf.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> resultList = new ArrayList<>();
        Collections.sort(nums);
        Predicate<Integer> isEven = x -> x % 2 == 0;
        for (Integer num : nums) {
            if(isEven.test(num)){
                resultList.add(num);
            }
        }
        for (Integer num : nums) {
            if(!isEven.test(num)){
                resultList.add(num);
            }
        }
        System.out.println(resultList.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",",""));
    }
}
