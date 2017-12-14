package _06_StringProcessingEX;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] banned = scanner.nextLine().split(", ");
        String text = scanner.nextLine();
        for (String s : banned) {
            text = checkAndReplace(text, s);
        }
        printText(text);
    }

    private static void printText(String text) {
        System.out.println(text);
    }

    private static String checkAndReplace(String text, String s) {
        StringBuilder sb = new StringBuilder(text);
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(sb);
        while(matcher.find()){
            int startIndex = matcher.start();
            int endIndex = matcher.end();
            String stars = new String(new char[s.length()]).replace("\0","*");
            sb.replace(startIndex, endIndex, stars);
        }

       return sb.toString();
    }
}
