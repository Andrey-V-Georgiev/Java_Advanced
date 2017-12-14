package _11_FunctionalProgrammingEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;


public class _00_Test {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());
        BiPredicate<Integer, Integer> removeByDivisor = (x, y) -> x % y == 0;

        System.out.println(removeByDivisor.test(a, b));
    }
}
