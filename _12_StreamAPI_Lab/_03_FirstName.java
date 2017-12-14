package _12_StreamAPI_Lab;

import java.util.*;

public class _03_FirstName {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.asList(scanner.nextLine().split("\\s+"));
        HashSet<Character> chars = new HashSet<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(s -> Character.toLowerCase(s.charAt(0)))
                .forEach(chars::add); //(c -> chars.add(c))

        Optional<String> firstName = names.stream()
                .filter(n -> chars.contains(n.toLowerCase().charAt(0)))
                .sorted()
               .findFirst();

        if(firstName.isPresent()){
            System.out.println(firstName.get());
        } else {
            System.out.println("No match");
        }


    }
}
