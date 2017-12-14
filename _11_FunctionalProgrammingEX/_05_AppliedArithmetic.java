package _11_FunctionalProgrammingEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _05_AppliedArithmetic {
    static Function<Integer, Integer> addToNum;
    static Function<Integer, Integer> multiplyNum;
    static Function<Integer, Integer> subtractNum;
    static List<Integer> numList;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        numList = Stream.of(bf.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        addToNum = x -> x + 1;
        multiplyNum = x -> x * 2;
        subtractNum = x -> x - 1;

        String command = bf.readLine();
        while (!command.equals("end")) {

            for (int i = 0; i < numList.size(); i++) {
                switch (command) {
                    case "add":
                        numList.set(i, addToNum.apply(numList.get(i)));
                        break;
                    case "multiply":
                        numList.set(i, multiplyNum.apply(numList.get(i)));
                        break;
                    case "subtract":
                        numList.set(i, subtractNum.apply(numList.get(i)));
                        break;
                    default:
                        break;
                }
            }

            if (command.equals("print")) {
                printList(numList);
            }

            command = bf.readLine();
        }
    }

    public static void printList(List<Integer> numList) {
        System.out.println(numList.toString()
                .replace("[", "")
                .replace(",", "")
                .replace("]", ""));
    }
}
