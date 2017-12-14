package _03_AbstractionLab;

        import java.util.*;

public class _02_EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine().trim();
            int sum = sumCounter(name);
            list.add(sum);
        }
        Collections.sort(list);
        printList(list);

    }

    private static void printList(List<Integer> list) {
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    private static int sumCounter(String name) {
        int sum = 0;
        char[] chars = name.toCharArray();
        for (char c : chars) {
            int currNum = (int) c;
            if (checkVowel(c)) {
                sum += currNum * name.length();
            } else {
                sum += currNum / name.length();
            }
        }
        return sum;
    }

    private static boolean checkVowel(char c) {
        List<Character> vowels = new ArrayList<>();
        Collections.addAll(vowels, 'a','e','u','i','o','A','E','O','U','I');
        boolean isVowel = vowels.contains(c);
        return isVowel;
    }
}
