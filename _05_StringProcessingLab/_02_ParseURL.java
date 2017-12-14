package _05_StringProcessingLab;

import java.util.Scanner;

public class _02_ParseURL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String url = scanner.nextLine();
            String[] splittedURL = url.split("://");

           /* if (splittedURL.length > 2) {
                System.out.println("Invalid URL");
                return;
            }*/
            String protocol = splittedURL[0];
            int indexServerEnd = splittedURL[1].indexOf("/");
            /*if (indexServerEnd == 1) {
                System.out.println("Invalid URL");
                return;
            }*/
            String server = splittedURL[1].substring(0, indexServerEnd);
            String resources = splittedURL[1].substring(indexServerEnd + 1, splittedURL[1].length());


            System.out.printf("Protocol = %s%nServer = %s%nResources = %s%n", protocol, server, resources);
        } catch (Exception e) {
            System.out.println("Invalid URL");
            return;
        }

    }
}
