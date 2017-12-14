package _08_DataReprAndManEX;

        import java.util.Arrays;
        import java.util.Scanner;

public class _07_FindMissNumStoqn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            counter++;
            if (arr[i] != counter) {
                System.out.println(counter);
                break;
            }
            if (i == arr.length - 1) {
                System.out.println(n);
            }
        }
    }
}
