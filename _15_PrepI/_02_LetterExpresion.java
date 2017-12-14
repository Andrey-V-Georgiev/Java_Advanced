package _15_PrepI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _02_LetterExpresion {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(input);

        String regex = "([^\\d-+]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            int startIndex = matcher.start();
            int endIndex = matcher.end();
            int diff = endIndex - startIndex;
            String action = "";
            if (diff % 2 == 0) {
                action = "+";
            } else {
                action = "-";
            }
            sb.replace(startIndex, endIndex, action);
            matcher = pattern.matcher(sb);
        }
        Deque<Integer> queueNums = new ArrayDeque<>();
        Deque<String> queueActions = new ArrayDeque<>();
        List<String> nums = Stream.of(sb.toString().split("[-+]")).collect(Collectors.toList());
        for (String num : nums) {
            queueNums.add(Integer.parseInt(num));
        }
        List<String> actions = Stream.of(sb.toString().split("\\d+")).collect(Collectors.toList());
        for (String action : actions) {
            queueActions.add(action);
        }
        int sum = queueNums.poll();
        while (!queueNums.isEmpty()) {
            String currAction = queueActions.poll();
            switch (currAction) {
                case "+":
                    sum += queueNums.poll();
                    break;
                case "-":
                    sum -= queueNums.poll();
                    break;
            }
        }
        System.out.println(sum);
    }
}
