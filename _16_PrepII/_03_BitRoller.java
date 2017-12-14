package _16_PrepII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class _03_BitRoller {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int decimalInteger = Integer.parseInt(bf.readLine());
        int frozenInput = Integer.parseInt(bf.readLine());
        int iterationCount = Integer.parseInt(bf.readLine());

        String decimalString = String.format("%19s",Integer.toBinaryString(decimalInteger)).replace(" ","0");
        int frozenIndex = decimalString.length() - 1 - frozenInput;
        char frozenChar = decimalString.charAt(frozenIndex);
        String stringWithoutFrozenChar = decimalString.substring(0, frozenIndex) + decimalString.substring(frozenIndex + 1, decimalString.length());
        ArrayDeque<Character> deque =  new ArrayDeque<>();
        for (int i = 0; i < stringWithoutFrozenChar.length(); i++) {
            deque.add(stringWithoutFrozenChar.charAt(i));
        }
        for (int i = 0; i < iterationCount; i++) {
            deque.addFirst(deque.removeLast());
        }
        StringBuilder sb = new StringBuilder();
        for (Character c :deque){
            sb.append(c);
        }
        sb.insert(frozenIndex,frozenChar);
        System.out.println(Integer.parseInt(sb.toString(),2));
    }
}
