package _09_ObjectsClassesAPIsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _06_SimpleTextEditor {
    static Deque<String> stack;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        stack = new ArrayDeque<>();

        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            String line = bf.readLine();
            char command = line.charAt(0);
            switch (command) {
                case '1':
                    appendStr(line);
                    break;
                case '2':
                    erase(line);
                    break;
                case '3':
                    printAt(line);
                    break;
                case '4':
                    undo(line);
                    break;
            }
        }
    }

    private static void undo(String line) {
        stack.pop();
        sb = new StringBuilder(stack.peek());
    }

    private static void printAt(String line) {
        List<String> lineArr = Stream.of(line.split(" ")).collect(Collectors.toList());
        int index = Integer.parseInt(lineArr.get(1));
        System.out.println(sb.charAt(index-1));
    }

    private static void erase(String line) {
        List<String> lineArr = Stream.of(line.split(" ")).collect(Collectors.toList());
        int n = Integer.parseInt(lineArr.get(1));
        for (int i = 0; i < n; i++) {
            sb.deleteCharAt(sb.length() - 1);

        }
        String temp = sb.toString();
        stack.push(temp);
    }

    private static void appendStr(String line) {
        List<String> lineArr = Stream.of(line.split(" ")).collect(Collectors.toList());
        String currStr = lineArr.get(1);
        sb.append(currStr);
        String temp = sb.toString();
        stack.push(temp);
    }
}
