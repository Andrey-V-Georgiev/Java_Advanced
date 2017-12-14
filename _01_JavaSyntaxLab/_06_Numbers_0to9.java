package _01_JavaSyntaxLab;

import java.util.Scanner;

public class _06_Numbers_0to9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = 0;
        while(counter<10){
            System.out.println("Number: " + counter);
            counter++;
        }
    }
}
