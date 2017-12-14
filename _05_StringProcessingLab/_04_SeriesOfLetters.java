package _05_StringProcessingLab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04_SeriesOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Pattern pattern = Pattern.compile("([\\w\\s])\\1*");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()){
            String letter = matcher.group(1);
            System.out.printf("%s",letter);
        }
    }
}
