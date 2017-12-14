package _10_FunctionalProgrammingLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _02_SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> listNum = Stream.of(bf.readLine().split(", ")).map(String::trim)
                .map(Integer::valueOf).collect(Collectors.toList());
        Function<List<Integer>, Integer> sumTheLIst = (x) -> {
            int sum = 0;
            for (int i = 0; i < x.size(); i++) {
                sum += x.get(i);
            }
            return sum;
        };

        System.out.printf("Count = %d%n",listNum.size());
        int sum1 = sumTheLIst.apply(listNum);
        System.out.printf("Sum = %d", sum1);
    }
}
