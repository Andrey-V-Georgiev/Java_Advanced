package _01_JavaSyntaxLab;

        import java.util.Scanner;

public class _01_Read_Input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstStr = scanner.next("\\w+");
        String secondStr = scanner.next("\\w+");

        int firstInt = scanner.nextInt();

        double firstDouble= scanner.nextDouble();
        double secondDouble = scanner.nextDouble();

        scanner.nextLine();
        String thirdStr = scanner.nextLine();

        int sum = firstInt + (int)firstDouble + (int)secondDouble;

        System.out.printf("%s %s %s %d",firstStr ,secondStr ,thirdStr ,sum);
    }
}
