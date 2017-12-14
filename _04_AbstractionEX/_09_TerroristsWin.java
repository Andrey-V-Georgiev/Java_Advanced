package _04_AbstractionEX;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _09_TerroristsWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\|(.*?)\\|");
        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();
        sb.append(input);

        while (matcher.find()) {
            String bomb = matcher.group(1);
            int power = findBombPower(bomb);
            int startIndex = matcher.start();
            int endIndex = matcher.end();
            int startReplace = Math.max((startIndex - power),0);
            int endReplace = Math.min((endIndex + power),sb.length());
            int charArrLength = endReplace - startReplace;
            String str = new String(new char[charArrLength]).replace("\0", ".");
            sb.replace(startReplace, endReplace, str);
        }
        System.out.println(sb.toString());
    }

    private static int findBombPower(String bomb) {
        int sum = 0;
        for (char c : bomb.toCharArray()) {
            sum += (int) c;
        }
        int power = sum % 10;
        return power;
    }
}
