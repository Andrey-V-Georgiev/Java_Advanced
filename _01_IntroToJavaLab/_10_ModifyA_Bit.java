package _01_IntroToJavaLab;

import java.util.Arrays;
import java.util.Scanner;

public class _10_ModifyA_Bit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = input[0];
        int p = input[1];
        int v = input[2];
        int result = 0;

        if(v==0) {
            int mask = ~(1 << p);
           result = n & mask;
        }else if(v==1){
            int mask = 1 << p;
           result = n | mask;
        }


        System.out.println(result);

    }
}
