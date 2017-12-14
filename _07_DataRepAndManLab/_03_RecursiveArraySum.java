package _07_DataRepAndManLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class _03_RecursiveArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int index = 0;
        int output = sum(intArr, index);
        StringBuilder sb = new StringBuilder();
        sb.append(output);
        System.out.println(sb.toString());
    }

    private static int sum(int[] intArr, int index) {
        if(index == intArr.length-1){
            return intArr[index];
        }

        return intArr[index] + sum(intArr, index + 1);
    }
}
