package _12_RegularExpressionsLab;


import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06_ValidUsernames {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("^[\\w_-]{3,16}$");
        String line = scanner.nextLine();

        while (!line.equals("END")) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
            line = scanner.nextLine();
        }
    }
}
