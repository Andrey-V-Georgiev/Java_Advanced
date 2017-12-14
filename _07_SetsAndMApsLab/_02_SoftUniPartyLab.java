package _07_SetsAndMApsLab;

import java.util.*;

public class _02_SoftUniPartyLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<String> vip = new HashSet<>();
        TreeSet<String> regular = new TreeSet<>();
        String input = scanner.nextLine();
        while (!"PARTY".equals(input)) {
            if (Character.isDigit(input.charAt(0))) {
                vip.add(input);
            } else {
                regular.add(input);
            }
            input = scanner.nextLine();
        }
        String guestsCome = scanner.nextLine();
        while (!"END".equals(guestsCome)) {
            if (Character.isDigit(guestsCome.charAt(0))) {
                vip.remove(guestsCome);
            } else {
                regular.remove(guestsCome);
            }
            guestsCome = scanner.nextLine();
        }
        regular.addAll(vip);
        System.out.println(regular.size());
        for (String s : regular) {
            System.out.println(s);
        }
    }
}