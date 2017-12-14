package _15_PrepI;

import java.math.BigInteger;

public class _00_Test {
    public static void main(String[] args) {
        String a = "7";
        BigInteger bigInt = new BigInteger(a);
        String b = bigInt.toString(2);
        System.out.println(b);
    }
}
