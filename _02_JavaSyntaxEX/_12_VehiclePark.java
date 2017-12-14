package _02_JavaSyntaxEX;

import java.util.ArrayList;
import java.util.Scanner;

public class _12_VehiclePark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] allCars = scanner.nextLine().split(" ");
        int soldVehicles = 0;
        ArrayList<String> carsLeft = new ArrayList<>();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String rawInput = scanner.nextLine();
            String[] input = rawInput.toLowerCase().split(" ");

            if (rawInput.equals("End of customers!")) {
                break;
            }
            String currCar = input[0].charAt(0) + input[2];
            int availableVehicle = 0;
            for (int j = 0; j < allCars.length; j++) {

                if (allCars[j].equals(currCar)) {
                    availableVehicle++;
                    soldVehicles++;
                    allCars[j] = "sold";
                    int currPrice = (int) input[0].charAt(0) * Integer.parseInt(input[2]);
                    System.out.printf("Yes, sold for %d$%n", currPrice);
                    break;
                }
            }
            if (availableVehicle == 0) {
                System.out.println("No");
            }
        }
        for (String car : allCars) {
            if (!car.equals("sold")) {
                carsLeft.add(car);
            }
        }
        System.out.printf("Vehicles left: %s%n", String.join(", ", carsLeft));
        System.out.printf("Vehicles sold: %d", soldVehicles);
    }
}
