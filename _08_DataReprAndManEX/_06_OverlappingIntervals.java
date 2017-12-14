package _08_DataReprAndManEX;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class _06_OverlappingIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] line = Stream.of(scanner.nextLine().split(",")).mapToInt(Integer::valueOf).toArray();
            pairs.add(line);
        }

        for (int s1 = 0; s1 < n - 1; s1++) {
            for (int s2 = s1+1; s2 < n; s2++) {
                if(pairs.get(s2)[0] >= pairs.get(s1)[0] && pairs.get(s2)[0] <= pairs.get(s1)[1]
                || pairs.get(s2)[1] >= pairs.get(s1)[0] && pairs.get(s2)[1] <= pairs.get(s1)[1]){
                    System.out.println("true");
                    return;
                }
            }
        }
        System.out.println("false");
    }
}
