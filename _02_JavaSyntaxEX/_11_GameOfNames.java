package _02_JavaSyntaxEX;

import java.util.Scanner;

public class _11_GameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Object[][] matrixName = new Object[n][1];
        Object[][] matrixPoints = new Object[n][1];

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int points = scanner.nextInt();

            for (char c : name.toCharArray()) {
                int asciValue = (int) c;
                if(asciValue%2==0){
                    points+=asciValue;
                }
                else{
                    points-=asciValue;
                }
            }

            matrixName[i][0]=name;
            matrixPoints[i][0]=points;
        }

        int maxPoints=Integer.MIN_VALUE;
        int maxIndex=0;
        for (int i = 0; i < n; i++) {

            if((int)matrixPoints[i][0]>maxPoints){
                maxIndex=i;
                maxPoints=(int)matrixPoints[i][0];
            }
        }

        System.out.printf("The winner is %s - %d points", matrixName[maxIndex][0], matrixPoints[maxIndex][0]);
    }
}
