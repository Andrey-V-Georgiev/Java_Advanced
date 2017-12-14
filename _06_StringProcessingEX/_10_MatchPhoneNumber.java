package _06_StringProcessingEX;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _10_MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String regex = "^\\+359([\\s-])2\\1\\d{3}\\1\\d{4}$";
        String input = bf.readLine();
        while(!input.equals("end")){

            if(Pattern.matches(regex, input)){
                System.out.println(input);
            }
            input = bf.readLine();
        }
    }
}
