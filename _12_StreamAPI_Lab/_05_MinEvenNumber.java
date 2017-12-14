package _12_StreamAPI_Lab;

        import java.util.Arrays;
        import java.util.List;
        import java.util.OptionalDouble;
        import java.util.Scanner;

public class _05_MinEvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tokens = Arrays.asList(scanner.nextLine().split("\\s+"));

        OptionalDouble min = tokens.stream()
                .filter(x -> !x.isEmpty())
                .mapToDouble(Double::valueOf)
                .filter(x -> x % 2 == 0)
                .min();

        if(min.isPresent()){
            System.out.printf("%.2f",min.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
