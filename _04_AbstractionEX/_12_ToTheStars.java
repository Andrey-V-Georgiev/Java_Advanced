package _04_AbstractionEX;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _12_ToTheStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = new String[30][30];
        LinkedHashMap<String, double[]> stars = new LinkedHashMap<>();

        //read and fill the stars
        for (int i = 0; i < 3; i++) {
            String[] line = scanner.nextLine().split(" ");
            String name = line[0].trim();
            double x = Double.parseDouble(line[1].trim());
            double y = Double.parseDouble(line[2].trim());
            double[] arr = {x, y};
            stars.put(name, arr);
        }

        //read the Normandy coordinates
        String[] normandy = scanner.nextLine().split(" ");
        double x = Double.parseDouble(normandy[0]);
        double yStart = Double.parseDouble(normandy[1]);
        int moves = Integer.parseInt(scanner.nextLine().trim());


        double progress = yStart;
        for (int i = 0; i <= moves; i++) {
            boolean inside = false;
            for (Map.Entry<String, double[]> entry : stars.entrySet()) {
                double xE = entry.getValue()[0];
                double yE = entry.getValue()[1];
                if (x <= xE + 1 && x >= xE - 1) {
                    if (progress >= yE - 1 && progress <= yE + 1) {
                        inside = true;
                        String nameE = entry.getKey().toLowerCase();
                        System.out.println(nameE);
                    }
                }
            }
            if (inside == false) {
                System.out.println("space");
            }
            progress++;
        }
    }
}
