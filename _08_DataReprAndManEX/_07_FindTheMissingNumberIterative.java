package _08_DataReprAndManEX;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class _07_FindTheMissingNumberIterative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            long n = Long.parseLong(scanner.nextLine());
            if (n == 1) {
                System.out.println(1);
                return;
            }
            long[] nums = Stream.of(scanner.nextLine().split(", ")).mapToLong(Long::parseLong).toArray();
            long missingNum = 0;
            Arrays.sort(nums);

            if (Arrays.binarySearch(nums, 1) < 0) {
                missingNum = 1;
            }

            if (Arrays.binarySearch(nums, n) < 0) {
                missingNum = n;
            }

            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] - nums[i - 1] != 1 || nums[i + 1] - nums[i] != 1) {
                    missingNum = nums[i + 1] - 1;
                    break;
                }
            }
            System.out.println(missingNum);
        }catch(Exception e){

        }
    }
}
