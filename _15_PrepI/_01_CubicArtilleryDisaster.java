package _15_PrepI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;

public class _01_CubicArtilleryDisaster {
    static LinkedHashMap<String, Bunker> bunkers = new LinkedHashMap<>();
    static int maxCapacity;
    static int previousFreeSpace;
    static String previousKey;
    static ArrayDeque<Integer> waitingItems = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        fillTheBunkers();
        arrangeTheBunkers();
    }

    private static void arrangeTheBunkers() {
        for (Map.Entry<String, Bunker> currentBunker : bunkers.entrySet()) {    //rotate bunkers
            ArrayDeque<Integer> currentLoads = currentBunker.getValue().getLoads();
            ArrayDeque<Integer> tempDeque = new ArrayDeque<>();
            String currentKey = currentBunker.getKey();
            int currentFreeSpace = currentBunker.getValue().getFreeSpace();

            for (Integer currentLoad : currentLoads) {          //manage currentBunker's loads
                if (currentLoad > maxCapacity) {        //if the load is bigger than maxCapacity
                    currentLoads.removeFirst();
                    continue;
                }
                currentLoads.addAll(waitingItems);
                if (previousFreeSpace - currentLoad >= 0) {     //if there is a space in previous bunker
                    bunkers.get(previousKey).getLoads().add(currentLoads.removeFirst());
                    bunkers.get(previousKey).setFreeSpace(bunkers.get(previousKey).getFreeSpace() - currentLoad);
                    previousFreeSpace -= currentLoad;
                    if (bunkers.get(previousKey).getFreeSpace() == 0) {
                        printTheBunker(previousKey);
                        bunkers.remove(previousKey);
                    }
                } else if (currentFreeSpace - currentLoad >= 0) {     //if current load can be stored
                    tempDeque.add(currentLoads.removeFirst());
                    currentFreeSpace -= currentLoad;
                    if (bunkers.get(currentKey).getFreeSpace() == 0) {
                        printTheBunker(currentKey);
                        bunkers.remove(currentKey);
                    }
                } else {
                    waitingItems.add(currentLoads.removeFirst());     //if there is not enough space
                }
            }


            previousKey = currentKey;                                       //get access to previous object
            previousFreeSpace = currentFreeSpace;
            currentBunker.getValue().setFreeSpace(currentFreeSpace);        //set temporary values of currentBunker
            currentBunker.getValue().setLoads(tempDeque);
        }
        if (waitingItems.size() > 0) {
            processAgain();
        }
        printEmptyBunkers();
    }

    private static void processAgain() {
        for (Map.Entry<String, Bunker> bunker : bunkers.entrySet()) {    //rotate bunkers
            int currentFreeSpace = bunker.getValue().getFreeSpace();
            ArrayDeque<Integer> tempDeque = bunker.getValue().getLoads();
            ArrayDeque<Integer> removingDeque = new ArrayDeque<>();

            for (Integer item : waitingItems) {                          //rotate items
                while(true){
                    currentFreeSpace += tempDeque.removeFirst();
                    if(currentFreeSpace >= item){
                        bunker.getValue().getLoads().addLast(item);
                        currentFreeSpace -= item;
                        if(currentFreeSpace == 0){
                            printTheBunker(bunker.getKey());
                        }
                        removingDeque.add(item);
                        break;
                    }
                }
            }
            for (Integer integer : removingDeque) {
                waitingItems.removeFirst();
            }
        }
       return;
    }

    private static void printEmptyBunkers() {
        for (Map.Entry<String, Bunker> bunker : bunkers.entrySet()) {
            if (bunker.getValue().getFreeSpace() == maxCapacity) {
                System.out.println(bunker.getKey() + " -> Empty");
                return;
            }
        }
    }

    private static void printTheBunker(String key) {
        System.out.print(key + " -> ");
        ArrayDeque<Integer> currentLoads = bunkers.get(key).getLoads();
        System.out.println(currentLoads.toString().toString().replace("[", "").replace("]", ""));
    }

    public static void fillTheBunkers() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        maxCapacity = Integer.parseInt(bf.readLine());
        String readLine = bf.readLine();
        while (!"Bunker Revision".equals(readLine)) {           //getting the line
            String[] tokens = readLine.split("\\s+");
            for (int i = 0; i < tokens.length; i++) {          //getting the tokens
                String currentBunker = tokens[i];
                int counter = 0;
                Bunker newBunker = new Bunker();
                ArrayDeque<Integer> newDeque = new ArrayDeque<>();
                for (int j = i + 1; j < tokens.length; j++) {       //getting the weapons
                    if ((Character.isDigit(tokens[j].charAt(0)))) {
                        if (bunkers.containsKey(currentBunker)) {
                            bunkers.get(currentBunker).getLoads().add(Integer.parseInt(tokens[j]));
                        } else {
                            newDeque.add(Integer.parseInt(tokens[j]));
                            newBunker.setLoads(newDeque);
                            bunkers.put(currentBunker, newBunker);
                        }
                    } else {
                        break;
                    }
                    counter = j;
                }
                i += counter;
            }
            readLine = bf.readLine();
        }
        for (Bunker bunker : bunkers.values()) {
            bunker.setFreeSpace(maxCapacity);
        }
    }

    static class Bunker {
        private int freeSpace;
        private ArrayDeque<Integer> loads;

        public Bunker() {
        }

        public Bunker(int freeSpace, int loadedSpace, ArrayDeque<Integer> loads) {
            this.freeSpace = freeSpace;
            this.loads = loads;
        }

        public int getFreeSpace() {
            return freeSpace;
        }

        public void setFreeSpace(int freeSpace) {
            this.freeSpace = freeSpace;
        }

        public ArrayDeque<Integer> getLoads() {
            return loads;
        }

        public void setLoads(ArrayDeque<Integer> loads) {
            this.loads = loads;
        }
    }
}
