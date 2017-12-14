package _01_JavaSyntaxLab;


import java.math.BigDecimal;
import java.util.Scanner;

public class _03_EuroTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double quantity = scanner.nextDouble();
        double pricePerKg = 1.2;
        BigDecimal exchangeRate = new BigDecimal("4210500000000");
        BigDecimal priceLv = new BigDecimal(quantity * pricePerKg);
        BigDecimal priceInDm = exchangeRate.multiply(priceLv);
        System.out.printf("%.2f marks",priceInDm);
    }
}
