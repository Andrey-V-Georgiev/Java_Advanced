package _12_StreamAPI_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _02_UpperStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.print(s + " "));
    }
}
