package _12_RegularExpressionsLab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _00_Tests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(scanner.nextLine());
        while(matcher.find()){
            String symbol = matcher.group();
            System.out.println(symbol);
        }

    }
}
