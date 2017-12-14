package _09_ObjectsClassesAPIsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.stream.Stream;

public class _02_MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            String input = bf.readLine();
            char command = input.charAt(0);

                switch (command) {
                case '1':
                    stack.push(Stream.of(input.split(" ")).mapToInt(Integer::parseInt).toArray()[1]);
                    break;
                case '2':
                    stack.pop();
                    break;
                case '3':
                    if(!stack.isEmpty()){
                        System.out.println(Collections.max(stack));
                    }
                    break;
            }
        }
    }
}
