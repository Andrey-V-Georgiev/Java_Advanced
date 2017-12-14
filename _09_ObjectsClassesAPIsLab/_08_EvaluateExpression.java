package _09_ObjectsClassesAPIsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _08_EvaluateExpression {

    public static final int LEFT_ASSOC = 0;
    public static final int RIGHT_ASSOC = 1;
    public static final Map<String, int[]> ARITH_OPERATORS = new HashMap<String, int[]>();
    public static final Map<String, int[]> REL_OPERATORS = new HashMap<String, int[]>();
    public static final Map<String, int[]> LOG_OPERATORS = new HashMap<String, int[]>();
    public static final Map<String, int[]> OPERATORS = new HashMap<String, int[]>();

    public static void main(String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String inputExpression =bf.readLine();
        String[] input = inputExpression.split(" ");
        List<String> output = infixToRPN(input);
        String postfix = output.toString()
                .replace("[", "")
                .replace(",", "")
                .replace("]", "");
        Double value = evaluate(postfix);
        System.out.printf("%.2f",value);
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

    static {
        ARITH_OPERATORS.put("+", new int[]{25, LEFT_ASSOC});
        ARITH_OPERATORS.put("-", new int[]{25, LEFT_ASSOC});
        ARITH_OPERATORS.put("*", new int[]{30, LEFT_ASSOC});
        ARITH_OPERATORS.put("/", new int[]{30, LEFT_ASSOC});
        ARITH_OPERATORS.put("%", new int[]{30, LEFT_ASSOC});
        ARITH_OPERATORS.put("^", new int[]{35, RIGHT_ASSOC});
        ARITH_OPERATORS.put("**", new int[]{30, LEFT_ASSOC});

        REL_OPERATORS.put("<", new int[]{20, LEFT_ASSOC});
        REL_OPERATORS.put("<=", new int[]{20, LEFT_ASSOC});
        REL_OPERATORS.put(">", new int[]{20, LEFT_ASSOC});
        REL_OPERATORS.put(">=", new int[]{20, LEFT_ASSOC});
        REL_OPERATORS.put("==", new int[]{20, LEFT_ASSOC});
        REL_OPERATORS.put("!=", new int[]{20, RIGHT_ASSOC});

        LOG_OPERATORS.put("!", new int[]{15, RIGHT_ASSOC});

        LOG_OPERATORS.put("&&", new int[]{10, LEFT_ASSOC});

        LOG_OPERATORS.put("||", new int[]{5, LEFT_ASSOC});

        LOG_OPERATORS.put("EQV", new int[]{0, LEFT_ASSOC});
        LOG_OPERATORS.put("NEQV", new int[]{0, LEFT_ASSOC});

        OPERATORS.putAll(ARITH_OPERATORS);
        OPERATORS.putAll(REL_OPERATORS);
        OPERATORS.putAll(LOG_OPERATORS);
    }

    private static boolean isAssociative(String token, int type) {

        if (!isOperator(token)) {
            System.out.println("");
        }
        if (OPERATORS.get(token)[1] == type) {
            return true;
        }
        return false;
    }

    private static boolean isOperator(String token) {
        return OPERATORS.containsKey(token);
    }

    private static int cmpPrecedence(String token1, String token2) {
        if (!isOperator(token1) || !isOperator(token2)) {
            System.out.println("");
        }
        return OPERATORS.get(token1)[0] - OPERATORS.get(token2)[0];
    }

    private static ArrayList<String> infixToRPN(String[] inputTokens) {
        ArrayList<String> out = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        for (String token : inputTokens) {
            if (isOperator(token)) {
                while (!stack.empty() && isOperator(stack.peek())) {
                    if ((isAssociative(token, LEFT_ASSOC) && cmpPrecedence(token, stack.peek()) <= 0)
                            || (isAssociative(token, RIGHT_ASSOC) && cmpPrecedence(token, stack.peek()) < 0)) {
                        out.add(stack.pop());
                        continue;
                    }
                    break;
                }
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.empty() && !stack.peek().equals("(")) {
                    out.add(stack.pop());
                }
                stack.pop();
            } else {
                out.add(token);
            }
        }
        while (!stack.empty()) {
            out.add(stack.pop());
        }
        return out;
    }
}
