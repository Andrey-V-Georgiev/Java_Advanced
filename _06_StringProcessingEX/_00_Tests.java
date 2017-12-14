package _06_StringProcessingEX;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _00_Tests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(?<=^|.|,| )[a-zA-Z0-9]+[.,-_]*[a-zA-Z0-9]*@[a-zA-Z0-9-]+([.a-zA-Z-]+)\\1*(?=,|.|$)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);


        while( matcher.find()) {
            String curMatch = matcher.group(0);
            System.out.println(curMatch);
        }
    }
}
