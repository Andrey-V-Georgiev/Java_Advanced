package _02_JavaSyntaxEX;

import java.util.ArrayList;
import java.util.Scanner;

public class _05_FromDecimalToBaseSeven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int base = 7;
        int result = 0;
        int rest = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            result = num / base;
            if(result<=0){
                result=num;
                list.add(0, result);
                break;
            }
            rest = num % base;
            list.add(0, rest);
            num = result;
        }

        for (Integer i : list) {
            System.out.print(i);
        }
    }
}