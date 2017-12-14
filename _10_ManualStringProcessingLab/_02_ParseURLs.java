package _10_ManualStringProcessingLab;

import java.util.Scanner;

public class _02_ParseURLs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] reminder = input.split("://");
        if(reminder.length!=2){
            System.out.println("Invalid URL");
        }

        int index = reminder[1].indexOf("/");
        String protocol = String.format("Protocol = %s", reminder[0]);
        String server = String.format("Server = %s",reminder[1].substring(0, index));
        String resources = String.format("Resources = %s",reminder[1].substring(index + 1));
        System.out.printf("%s%n%s%n%s",protocol ,server ,resources);

    }
}
