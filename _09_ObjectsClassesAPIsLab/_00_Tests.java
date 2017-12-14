package _09_ObjectsClassesAPIsLab;

import java.util.Stack;

public class _00_Tests {
    public static void main(String[] args) {
        String postfix = "1 2 + 3 +";
        Double value = evaluate(postfix);
        System.out.println(value);
    }

    public static Double evaluate(String postfix) {
        Stack<Double> s = new Stack<Double>();
        char[] chars = postfix.toCharArray();
        int N = chars.length;
        for (int i = 0; i < N; i++) {
            char ch = chars[i];
            if (isOperator(ch)) {
                switch (ch) {
                    case '+':
                        s.push(s.pop() + s.pop());
                        break;
                    case '*':
                        s.push(s.pop() * s.pop());
                        break;
                    case '-':
                        s.push(-s.pop() + s.pop());
                        break;
                    case '/':
                        s.push(1 / s.pop() * s.pop());
                        break;
                }
            } else if (Character.isDigit(ch)) {
                s.push(0.0);
                while (Character.isDigit(chars[i]))
                    s.push(10.0 * s.pop() + (chars[i++] - '0'));
            }
        }
        if (!s.isEmpty())
            return s.pop();
        else
            return 0.0;
    }

    private static boolean isOperator(char ch) {
        return ch == '*' || ch == '/' || ch == '+' || ch == '-';
    }

}
