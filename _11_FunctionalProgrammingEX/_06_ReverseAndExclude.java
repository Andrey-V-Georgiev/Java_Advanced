package _11_FunctionalProgrammingEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _06_ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums = Stream.of(bf.readLine().split("\\s+"))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        int divisor = Integer.parseInt(bf.readLine());
        Collections.reverse(nums);
        BiPredicate<Integer, Integer> removeByDivisor = (x, y) -> x % y == 0;

        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            int currNum = nums.get(i);
            boolean isDivisible = removeByDivisor.test(currNum, divisor);
            if(isDivisible){
                nums.set(i, null);
            }
        }
        for (Integer num : nums) {
            if(num != null){
                resultList.add(num);
            }
        }

        printResultList(resultList);
    }

    private static void printResultList(List<Integer> nums) {
        System.out.println(nums.toString()
                .replace("[","")
                .replace(",","")
                .replace("]",""));
    }
}
