package _10_FunctionalProgrammingLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _04_AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Double> input = Stream.of(bf.readLine().split(", ")).map(Double::valueOf)
                .collect(Collectors.toList());
        System.out.println("Prices with VAT:");

        UnaryOperator<Double> addVAT = x -> x * 1.2;

        for (int i = 0; i < input.size(); i++) {
            String curr = String.format("%.2f",addVAT.apply(input.get(i))).replace('.',',');
            System.out.println(curr);
        }
    }
}
