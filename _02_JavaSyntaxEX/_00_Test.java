package _02_JavaSyntaxEX;

import java.util.Scanner;

public class _00_Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     String[] a = {"4", "9", "7"};
     String b =String.join(", ", a);
        System.out.println(b);
    }
}