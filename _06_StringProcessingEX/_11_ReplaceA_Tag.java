package _06_StringProcessingEX;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _11_ReplaceA_Tag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String regex = "(<a) href|(?<=href=).+?(>)|(<\\/a>)";
        Pattern pattern = Pattern.compile(regex);
        String input = scanner.nextLine();
        Deque<String> replStr = new ArrayDeque<>();
        replStr.add("[URL");
        replStr.add("]");
        replStr.add("[/URL]");
        Deque<Integer> groups = new ArrayDeque<>();
        groups.add(1);
        groups.add(2);
        groups.add(3);

        while (!input.equals("END")) {
            Matcher matcher = pattern.matcher(input);
            String line = replaceAnchorTag(matcher, input, replStr, groups);
            System.out.println(line);
            input = scanner.nextLine();
        }
    }

    private static String replaceAnchorTag(Matcher matcher, String input, Deque<String> replStr,Deque<Integer> groups) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        int diff= 0;
        while (matcher.find()) {
            int matchCount = matcher.groupCount();
            String replacingStr = replStr.remove();
            int group = groups.remove();
            int startIndex = matcher.start(group);
            int endIndex = matcher.end(group);

            int start = startIndex + diff;
            int end = endIndex + diff;
            sb.replace(start, end, replacingStr);
            diff = replacingStr.length() - (endIndex-startIndex) + diff;
        }
        return sb.toString();
    }
}


