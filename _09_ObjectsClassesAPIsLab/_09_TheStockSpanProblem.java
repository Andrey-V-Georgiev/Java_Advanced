package _09_ObjectsClassesAPIsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _09_TheStockSpanProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] price = new int[n];

        for (int i = 0; i < n; i++) {
            int currNum = Integer.parseInt(bf.readLine());
            price[i]= currNum;
        }
        int arr[]= new int[n];
        //calculateSpan(price, n, arr);
        arr[0] = 1;
        for (int i = 1; i < n; i++)
        {
            arr[i] = 1;
            for (int j = i-1; (j>=0)&&(price[i]>=price[j]); j--)
                arr[i]++;
        }
        //printArray(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    static void calculateSpan(int price[], int n, int arr[])
    {
        arr[0] = 1;
        for (int i = 1; i < n; i++)
        {
            arr[i] = 1;
            for (int j = i-1; (j>=0)&&(price[i]>=price[j]); j--)
                arr[i]++;
        }
    }

    static void printArray(int arr[])
    {
        for (int i : arr) {
            System.out.println(i);
        }
    }
}


