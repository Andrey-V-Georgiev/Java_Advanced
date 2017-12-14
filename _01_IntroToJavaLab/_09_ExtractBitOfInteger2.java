package _01_IntroToJavaLab;

        import java.util.Scanner;

public class _09_ExtractBitOfInteger2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int p = Integer.parseInt(input[1]);

        int mask = n >> p;
        int bit = mask & 1;
        System.out.println(bit);

    }
}
