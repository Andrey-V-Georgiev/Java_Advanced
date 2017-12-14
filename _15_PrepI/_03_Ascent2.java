package _15_PrepI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_Ascent2 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String readLine = bf.readLine();
        while (!"Ascend".equals(readLine)) {
            processTheLine(readLine);
            readLine = bf.readLine();
        }
    }

    private static void processTheLine(String readLine) {
        String regex = "([,_])([a-zA-Z]+)([0-9])";
        Pattern pattern = Pattern.compile(regex);
        String lastVersion = readLine;
        Matcher matcher = pattern.matcher(lastVersion);
        while (matcher.find()) {
            lastVersion = makeTheLastVersion(matcher, lastVersion);
            matcher = pattern.matcher(lastVersion);
        }
        System.out.println(lastVersion);
    }

    private static String makeTheLastVersion(Matcher matcher, String lastVersion) {
        String front = matcher.group(1);
        String body = matcher.group(2);
        int back = Integer.parseInt(matcher.group(3));
        int start = matcher.start();
        int end = matcher.end();
        StringBuilder sbLastVersion = new StringBuilder();
        sbLastVersion.append(lastVersion);
        switch (front) {
            case ",":
                StringBuilder newBody = new StringBuilder();
                for (int i = 0; i < body.length(); i++) {
                    char newChar = (char)(body.charAt(i) + back);
                    newBody.append(newChar);
                }
                sbLastVersion.replace(start, end, newBody.toString());
                break;
            case "_":
                newBody = new StringBuilder();
                for (int i = 0; i < body.length(); i++) {
                    char newChar = (char)(body.charAt(i) - back);
                    newBody.append(newChar);
                }
                sbLastVersion.replace(start, end, newBody.toString());
                break;
        }
        return sbLastVersion.toString();
    }
}


