package _07_DataRepAndManLab;

import java.util.Collections;
import java.util.Scanner;

public class _05_RecursiveDrawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printFigure(n);
    }

    static void printFigure(int n) {
        if (n == 0) // Bottom of the recursion
            return;

        System.out.println(String.join("", Collections.nCopies(n, "*")));
        printFigure(n - 1);

        System.out.println(
                String.join("", Collections.nCopies(n, "#")));
    }
}
