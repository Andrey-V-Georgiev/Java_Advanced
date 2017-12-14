package _07_DataRepAndManLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class _02_SearchingBinary {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int key = Integer.parseInt(bf.readLine());
        int index = Arrays.binarySearch(arr, key);

        if (index < 0 || arr.length < index){
            System.out.println(-1);
        }else{
            System.out.println(index);
        }

    }
}
