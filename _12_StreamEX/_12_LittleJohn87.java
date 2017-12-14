package _12_StreamEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _12_LittleJohn87 {
    static int counterL;
    static int counterM;
    static int counterS;

    public static void main(String[] args) throws IOException {
        findArrowsScore();
        printResult();

    }

    private static void printResult() {
        String stageOneString = "" + counterS + counterM + counterL;
        int stageOneInt = Integer.parseInt(stageOneString);
        String stageBinaryString = Integer.toBinaryString(stageOneInt);
        StringBuilder sb = new StringBuilder();
        sb.append(stageBinaryString).reverse();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(stageBinaryString).append(sb);
        String concatenatedBinaryString = sb2.toString();
        double decimalResult = calculateDecimalResult(concatenatedBinaryString);
        System.out.println((int)decimalResult);
    }

    private static double calculateDecimalResult(String concatenatedBinaryString) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < concatenatedBinaryString.length(); i++) {
            numList.add(concatenatedBinaryString.charAt(i) - 48);
        }
        double sum = 0;
        int powCounter = 0;
        for (int i = numList.size()-1; i >= 0; i--) {
            double currNum = numList.get(i) * Math.pow(2, powCounter);
            sum += currNum;
            powCounter++;
        }
        return sum;
    }

    public static void findArrowsScore() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String regexLarge = ">>>----->>";
        String regexMedium = ">>----->";
        String regexSmall = ">----->";
        Pattern patternLarge = Pattern.compile(regexLarge);
        Pattern patternMedium = Pattern.compile(regexMedium);
        Pattern patternSmall = Pattern.compile(regexSmall);
        counterL = 0;
        counterM = 0;
        counterS = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            String line = bf.readLine();
            sb.append(line);

            Matcher matcherLarge = patternLarge.matcher(sb);
            while (matcherLarge.find()) {
                int startL = matcherLarge.start();
                int endL = matcherLarge.end();
                queue.add(startL);
                queue.add(endL);
                counterL++;
            }
            while (!queue.isEmpty()) {
                int startL = queue.poll();
                int endL = queue.poll();
                int diff = endL - startL;
                String filler = new String(new char[diff]).replace('\0', ' ');
                sb.replace(startL, endL, filler);
            }

            Matcher matcherMedium = patternMedium.matcher(sb);
            while (matcherMedium.find()) {
                int startM = matcherMedium.start();
                int endM = matcherMedium.end();
                queue.add(startM);
                queue.add(endM);
                counterM++;
            }
            while (!queue.isEmpty()) {
                int startM = queue.poll();
                int endM = queue.poll();
                int diff = endM - startM;
                String filler = new String(new char[diff]).replace('\0', ' ');
                sb.replace(startM, endM, filler);
            }

            Matcher matcherSmall = patternSmall.matcher(sb);
            while (matcherSmall.find()) {
                int startS = matcherSmall.start();
                int endS = matcherSmall.end();
                queue.add(startS);
                queue.add(endS);
                counterS++;
            }
            while (!queue.isEmpty()) {
                int startS = queue.poll();
                int endS = queue.poll();
                int diff = endS - startS;
                String filler = new String(new char[diff]).replace('\0', ' ');
                sb.replace(startS, endS, filler);
            }

        }
    }
}
