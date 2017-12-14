package _07_DataRepAndManLab;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

        import java.util.Arrays;

        import java.util.stream.Stream;

public class _01_SelectionSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        Arrays.sort(input);
        for (int i = 0; i < input.length; i++) {
            sb.append(input[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

}
