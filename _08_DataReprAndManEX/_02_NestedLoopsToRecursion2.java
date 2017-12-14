package _08_DataReprAndManEX;

import java.util.Scanner;

public class _02_NestedLoopsToRecursion2 {
    private static int n;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        arr = new int[n];
        int currIndex = 0;

        nestedLoops(currIndex);
    }

    public static void nestedLoops(int currIndex) {
        if (currIndex == n) {
            printLoops();
            return;
        }
        for (int indexValue = 1; indexValue <= n; indexValue++) {
            arr[currIndex] = indexValue;
            nestedLoops(currIndex + 1);
        }
    }

    public static void printLoops() {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
