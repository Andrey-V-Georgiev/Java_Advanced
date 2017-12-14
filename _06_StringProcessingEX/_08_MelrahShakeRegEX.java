package _06_StringProcessingEX;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _08_MelrahShakeRegEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(scanner.nextLine());
        String patternString = scanner.nextLine();

        while (true) {

                Deque<Integer> queue = new ArrayDeque<>();
                Pattern pattern = Pattern.compile(patternString);
                Matcher matcher = pattern.matcher(sb);


                queue = fillQueue(matcher, sb, queue);

                if (queue.size() == 0) {
                    System.out.println("No shake.");
                    break;
                }
                int firstMatchStart = queue.getFirst();
                int lastMatchStarts = queue.peekLast();
                int delLength = patternString.length();
                sb.delete(firstMatchStart, firstMatchStart + delLength);
                sb.delete(lastMatchStarts - delLength, lastMatchStarts);
                if (queue.size() >= 2) {
                    System.out.println("Shaked it.");
                } else {
                    System.out.println("No shake.");
                    break;
                }

                patternString = changePatternStr(patternString);
                if (patternString.isEmpty()) {
                    System.out.println("No shake.");
                    break;
                }

        }
        System.out.println(sb.toString());
    }

    private static Deque<Integer> fillQueue(Matcher matcher, StringBuilder sb, Deque<Integer> queue) {
        while (matcher.find()) {
            int startIndex = matcher.start();
            queue.add(startIndex);
        }
        return queue;
    }

    private static String changePatternStr(String patternString) {
        int delIndex = patternString.length() / 2;
        StringBuilder sbPatt = new StringBuilder(patternString);
        sbPatt.deleteCharAt(delIndex);
        return sbPatt.toString();
    }
}
