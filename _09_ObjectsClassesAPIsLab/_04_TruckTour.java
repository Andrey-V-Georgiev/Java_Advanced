package _09_ObjectsClassesAPIsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class _04_TruckTour {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] fuelCheckPoints = new int[n];
        int[] fuelNeededToNextCheckpoint = new int[n];
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int fuelAtCurrentPump = arr[0];
            int fuelNeededToNextStation = arr[1];
            fuelCheckPoints[i] = fuelAtCurrentPump;
            fuelNeededToNextCheckpoint[i] = fuelNeededToNextStation;
        }
        int fuel = 0;
        int counter = 0;
        for (int i = 0; i < n; i++) {
            fuel = 0;
            counter = 0;
            int index = i;
            while (true) {
                fuel += fuelCheckPoints[index];
                fuel -= fuelNeededToNextCheckpoint[index];
                if (fuel < 0) {
                    break;
                }
                counter++;
                if (counter == n) {
                    System.out.println(i);
                    return;
                }
                index++;
                if (index == n) {
                    index = 0;
                }
            }
        }

    }
}
