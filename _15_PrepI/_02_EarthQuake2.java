package _15_PrepI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class _02_EarthQuake2 {
    static int n;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));;
    static ArrayDeque<ArrayDeque<Integer>> queues= new ArrayDeque<>();;
    static List<Integer> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        readTheInput();
        processTheData();
        printResults();
    }

    private static void printResults() {
        System.out.println(results.size());
        System.out.println(results.toString().toString()
                .replace("[", "")
                .replace(",", "")
                .replace("]", ""));
    }

    private static void processTheData() {
        while(!queues.isEmpty()){
            ArrayDeque<Integer> currentQueue = queues.poll();
            int seismicity = currentQueue.poll();
            results.add(seismicity);
            while(!currentQueue.isEmpty()){
                int currentNum = currentQueue.poll();
                if(currentNum > seismicity){
                    currentQueue.push(currentNum);
                    queues.add(currentQueue);
                    break;
                }
            }
        }
    }

    public static void readTheInput() throws IOException {
        n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            ArrayDeque<Integer> newQueue = new ArrayDeque<>();
            String[] stringLine = bf.readLine().split("\\s+");
            for (int j = 0; j < stringLine.length; j++) {
                newQueue.add(Integer.parseInt(stringLine[j]));
            }
            queues.add(newQueue);
        }
    }
}
