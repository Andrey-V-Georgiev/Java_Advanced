package _01_JavaSyntaxLab;

import java.util.Scanner;

public class _04_Greeting {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();

        if(firstLine.isEmpty()){
            firstLine="*****";
        }
        if(secondLine.isEmpty()){
            secondLine="*****";
        }
        System.out.printf("Hello, %s %s!",firstLine , secondLine);
    }
}
