package _16_PrepII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _02_LetterExpression {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        List<Integer> numbers = Stream.of(input.split("\\D+")).map(Integer::parseInt).collect(Collectors.toList());
        List<String> letters = Stream.of(input.split("\\d+")).filter(x->!x.equals("")).collect(Collectors.toList());
        Deque<String> operations = new ArrayDeque<>();
        for (String letter : letters) {
            if(letter.length()%2==0){
                operations.add("+");
            } else {
                operations.add("-");
            }
        }
        Deque<Integer> numDeque = new ArrayDeque<>();
        numbers.stream().forEach(x ->numDeque.add(x) );

        int sum = numDeque.poll();
        while(true){
           try{
               String currOperation = operations.poll();
               switch (currOperation){
                   case "+": sum += numDeque.poll();break;
                   case "-": sum -= numDeque.poll();break;
               }
           }catch (Exception e){
               break;
           }
        }
        System.out.println(sum);
    }
}
