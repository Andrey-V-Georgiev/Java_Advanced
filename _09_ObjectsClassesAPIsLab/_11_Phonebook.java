package _09_ObjectsClassesAPIsLab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class _11_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> phoneBook = new HashMap<>();
        List<String> namesForCheck = new ArrayList<>();
        String inputNumbers = scanner.nextLine();
        while (!inputNumbers.equals("search")) {
            String[] inputArr = inputNumbers.split("-");
            String currName = inputArr[0];
            String currNum = inputArr[1];
            if (!phoneBook.containsKey(currName)) {
                phoneBook.put(currName, currNum);
            } else {
                phoneBook.replace(currName, currNum);
            }

            inputNumbers = scanner.nextLine();
        }
        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            namesForCheck.add(name);

            name = scanner.nextLine();
        }

        for (String currName : namesForCheck) {
            if (phoneBook.keySet().contains(currName)) {
                    String currNum = phoneBook.get(currName);
                    System.out.printf("%s -> %s%n", currName , currNum);
            } else {
                System.out.printf("Contact %s does not exist.%n", currName);
            }
        }
    }
}
