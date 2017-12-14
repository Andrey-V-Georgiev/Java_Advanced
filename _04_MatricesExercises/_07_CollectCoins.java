package _04_MatricesExercises;

import java.util.Scanner;

public class _07_CollectCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] jagged = new String[4][];

        //Fill the jagged matrix
        for (int row = 0; row < 4; row++) {
            String line = scanner.nextLine();
            jagged[row] = new String[line.length()];
            for (int i = 0; i < line.length(); i++) {
                jagged[row][i] = Character.toString(line.charAt(i));
            }
        }

        //Receive the commands and fill them in array
        String rawCommands = scanner.nextLine();
        String[] commands = new String[rawCommands.length()];
        for (int i = 0; i < rawCommands.length(); i++) {
            commands[i] = String.valueOf(rawCommands.charAt(i));
        }

        //Start playing
        int moneyHits = 0;
        int wallHits = 0;
        int rowPosition = 0;
        int colPosition = 0;
        int Iteration = 0;

        for (int i = Iteration; i < commands.length; i++) {
            Iteration = i;
            String move = commands[i];
            try {
                switch (move) {
                    case "V":
                        rowPosition += 1;
                        break;
                    case "^":
                        rowPosition -= 1;
                        break;
                    case ">":
                        colPosition += 1;
                        break;
                    case "<":
                        colPosition -= 1;
                        break;
                }
                if (jagged[rowPosition][colPosition].equals("$")) {
                    moneyHits++;
                }

            } catch (Exception e) {
                switch (move) {
                    case "V":
                        rowPosition -= 1;
                        break;
                    case "^":
                        rowPosition += 1;
                        break;
                    case ">":
                        colPosition -= 1;
                        break;
                    case "<":
                        colPosition += 1;
                        break;
                }
                Iteration++;
                wallHits++;
                continue;
            }
        }

        //Print results
        System.out.printf("Coins = %d%n",moneyHits);
        System.out.printf("Walls = %d",wallHits);
    }
}
