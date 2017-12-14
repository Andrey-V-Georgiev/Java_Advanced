package _12_StreamEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _09_StudentsEnrolledIn2014or2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        while(!"END".equals(input)){
            if(input.equals("")){
                return;
            }
            String[] inputArr = input.split("\\s+");
            String facultyNumber = inputArr[0];
            if(facultyNumber.endsWith("15") || facultyNumber.endsWith("14")){
                String currentEstimates = input.substring(facultyNumber.length());
                System.out.println(currentEstimates.trim());
            }

            input = bf.readLine();
        }



    }
}
