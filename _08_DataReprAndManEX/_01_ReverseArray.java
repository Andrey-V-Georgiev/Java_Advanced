package _08_DataReprAndManEX;

import java.util.Scanner;
import java.util.stream.Stream;

public class _01_ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int i = 0;
        int[] output = reverseArr(arr, i);
        StringBuilder sb = new StringBuilder();
        for (int d : output) {
            sb.append(d + " ");
        }
        System.out.println(sb.toString());

    }

    private static int[] reverseArr(int[] arr, int i) {
        if(i==arr.length/2){
            return arr;
        }

        int temp = arr[i];
        arr[i] = arr[arr.length-i-1];
        arr[arr.length-i-1] = temp;

        return reverseArr( arr, i+1);
    }
}
