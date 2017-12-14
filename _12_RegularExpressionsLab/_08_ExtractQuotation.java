package _12_RegularExpressionsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _08_ExtractQuotation {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("('|\")(.+?)\\1");

        String line = reader.readLine();
        Matcher matcher = pattern.matcher(line);
        while(matcher.find()){
            System.out.println(matcher.group(2));
        }
    }
}
