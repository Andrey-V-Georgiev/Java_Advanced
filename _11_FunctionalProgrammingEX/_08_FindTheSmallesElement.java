package _11_FunctionalProgrammingEX;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _08_FindTheSmallesElement {
    public static void main(String[] args) throws IOException {
        List<Integer> nums = fillNumsList();
        int minIndex = findIndexMinNum(nums);
        printMinIndex(minIndex);
    }

    private static List<Integer> fillNumsList() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = Stream.of(bf.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        return nums;
    }

    private static int findIndexMinNum(List<Integer> nums) {
        Function<List<Integer>, Integer> getMinIndex = list -> {
            int minNum = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) <= minNum) {
                    minNum = nums.get(i);
                    minIndex = i;
                }
            }
            return minIndex;
        };
        return getMinIndex.apply(nums);
    }

    private static void printMinIndex(int indexMinNum) {
        System.out.println(indexMinNum);
    }
}
