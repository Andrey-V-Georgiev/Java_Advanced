package _11_FunctionalProgrammingEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class _01_ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split("\\s+");
        Consumer<String> print = x -> System.out.println(x);
        for (String s : input) {
            print.accept(s);
        }

    }
}
