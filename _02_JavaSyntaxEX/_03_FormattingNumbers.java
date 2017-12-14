package _02_JavaSyntaxEX;

import java.util.Scanner;

public class _03_FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        String aHex = Integer.toHexString(a).toUpperCase();
        String aBinaryStr = Integer.toBinaryString(a);
        int aBinary = Integer.parseInt(aBinaryStr);

        String aHexFormatted = String.format("%1$-10s",aHex);
        String aBinFormatted = String.format("%1$010d",aBinary);
        String bFormatted = String.format("%.2f",b);
        String bAligned = String.format("%1$10s",bFormatted);
        String cFormatted = String.format("%.3f",c);
        String cAligned = String.format("%1$-10s",cFormatted);
        System.out.printf("|%s|%s|%s|%s|",aHexFormatted,aBinFormatted,bAligned,cAligned);
    }
}
