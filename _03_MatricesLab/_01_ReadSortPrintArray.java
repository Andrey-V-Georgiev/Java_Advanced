package _03_MatricesLab;

import java.util.Arrays;
import java.util.Scanner;

public class _01_ReadSortPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] inputArr =  new String[n];
        for (int i = 0; i < n; i++) {
            inputArr[i]= scanner.nextLine();
        }
        Arrays.sort(inputArr);
        for (String s : inputArr) {
            System.out.println(s);
        }
    }
}
