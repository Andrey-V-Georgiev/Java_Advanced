package _08_DataReprAndManEX;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class _07_FindTheMissingNumberRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            long n = Long.parseLong(scanner.nextLine());
            if (n == 1) {
                System.out.println(1);
                return;
            }
            long[] nums = Stream.of(scanner.nextLine().split(", ")).mapToLong(Long::parseLong).toArray();
            long missNum = 0;
            Arrays.sort(nums);

            if (Arrays.binarySearch(nums, 1) < 0) {
                missNum = 1;
                System.out.println(missNum);
                return;
            }

            if (Arrays.binarySearch(nums, n) < 0) {
                missNum = n;
                System.out.println(missNum);
                return;
            }

            missNum = searchForMissingNum(nums, 1);
            System.out.println(missNum);

    }

    private static long searchForMissingNum(long[] nums, int i) {
        if(i==nums.length-2){
            return 1;
        }


        if (nums[i] - nums[i - 1] != 1 || nums[i + 1] - nums[i] != 1) {
            return nums[i + 1] - 1;

        }

        return searchForMissingNum(nums, i+1);
    }
}
