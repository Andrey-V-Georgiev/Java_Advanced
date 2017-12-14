package _11_FunctionalProgrammingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class _04_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        List<Double> numbers = new ArrayList<>();
        for (String s : input) {
            numbers.add(Double.parseDouble(s));
        }

        UnaryOperator<Double> addVat = x -> x * 1.2;
        System.out.println("Prices with VAT:");
        for (Double number : numbers) {
            String currentStr = String.format("%1$.2f",addVat.apply(number)).replace(".",",");
            System.out.println(currentStr);
        }

    }
}
