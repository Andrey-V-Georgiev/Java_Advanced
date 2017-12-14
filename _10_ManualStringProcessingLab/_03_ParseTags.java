package _10_ManualStringProcessingLab;

import java.util.Scanner;

public class _03_ParseTags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String upcase = "<upcase>";
        String upcaseClose = "</upcase>";

        while(input.contains(upcase)){
            int indexOfStart = input.indexOf(upcase);
            int indexOfEnd = input.indexOf(upcaseClose);

            String reminder = input.substring(indexOfStart + upcase.length(), indexOfEnd);
            input = input.replace(upcase + reminder + upcaseClose, reminder.toUpperCase());
        }
        System.out.println(input);
    }
}
