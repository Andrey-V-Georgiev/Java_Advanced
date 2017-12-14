package _08_DataReprAndManEX;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _03_ImplementBinarySearchUsingRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> array = Stream.of(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        int key = Integer.parseInt(scanner.nextLine());

        System.out.println(binarySearch(array, key, 0, array.size()));

    }

    private static int binarySearch(List<Integer> array, int key, int leftBorder, int rightBorder) {
       try {
           if (leftBorder <= rightBorder) {
               int middle = leftBorder + (rightBorder - leftBorder) / 2;
               if (key < array.get(middle)) {
                   return binarySearch(array, key, leftBorder, middle);
               } else if (key > array.get(middle)) {
                   return binarySearch(array, key, middle + 1, rightBorder);
               } else {
                   return middle;
               }
           }
       }catch(Exception e){
           return -1;
       }
        return -1;
    }
}
