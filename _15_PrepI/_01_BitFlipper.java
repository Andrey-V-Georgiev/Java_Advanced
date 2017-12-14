package _15_PrepI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class _01_BitFlipper {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        BigInteger bigInt = new BigInteger(bf.readLine());

        String binaryString = String.format("%64s",bigInt.toString(2)).replace(" ","0");

        binaryString = binaryString.replaceAll("000","zero");

        binaryString = binaryString.replaceAll("111","one");

        binaryString = binaryString.replaceAll("zero","111");

        binaryString = binaryString.replaceAll("one","000");

        BigInteger backToDecimal = new BigInteger(binaryString, 2);

        System.out.println(backToDecimal);
    }
}
