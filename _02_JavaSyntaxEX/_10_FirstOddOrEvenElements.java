package _02_JavaSyntaxEX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _10_FirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] intArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[] strArr = scanner.nextLine().split(" ");
        int count = Integer.parseInt(strArr[1]);
        String evenOrOdd = strArr[2];

        ArrayList<Integer> listResult = new ArrayList<>();
        for (int i = 0; i < intArr.length; i++) {
            switch (evenOrOdd) {
                case "even":
                    if (intArr[i] % 2 == 0) {
                        listResult.add(intArr[i]);
                    }
                    ;
                    break;
                case "odd":
                    if (intArr[i] % 2 != 0) {
                        listResult.add(intArr[i]);
                    }
                    ;
                    break;
            }
        }

        if(count>listResult.size()){
            count=listResult.size();
        }
        for (int i = 0; i < count ; i++) {
            System.out.print(listResult.get(i)+" ");
        }

    }
}
