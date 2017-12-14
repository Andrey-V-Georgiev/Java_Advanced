package _01_JavaSyntaxLab;

import java.util.Scanner;

public class _05_TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double distance = Double.parseDouble(scanner.nextLine());
        String dayOrNight = scanner.nextLine();

        double sum = 0.0;

        if (distance < 20) {
            double initialTax = 0.70;
            if (dayOrNight.equals("day")) {
                sum = initialTax + (distance * 0.79);
            } else {
                sum = initialTax + (distance * 0.90);
            }
        } else if (distance >= 20 && distance < 100) {
            sum = distance * 0.09;
        }
        else if(distance>=100){
            sum = distance * 0.06;
        }
        System.out.printf("%.2f",sum);
    }
}
