package _06_StringProcessingEX;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _12_ExtractEmailsNaStoqn {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("end")) {
                break;
            }
            sb.append(input).append(" ");
        }
        Pattern pattern = Pattern.compile("(^| )[a-z0-9]+(.|_|-)[a-z0-9]+@[a-z]+([a-z-.]+){1,}\\.[a-z]+([., $])");

        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            String match = matcher.group().trim();
            if (match.endsWith(",") || match.endsWith(".")) {
                match = match.substring(0, match.length() - 1);
            }
            System.out.println(match);
        }

    }
}
