package _15_PrepI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class _01_HandScore {
    static List<String> inputList;
    static List<Card> cards;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        inputList = new ArrayList<>();
        inputList = Stream.of(bf.readLine().split("\\s+")).distinct().collect(Collectors.toList());
        cards = new ArrayList<>();
        fillCardsList();
        sumResult();
        System.out.println(sum);
    }

    private static void sumResult() {

        for (int i = 0; i < cards.size(); i++) {
            int counter = 1;
            int startIndex = i;
            while (true) {
                if (startIndex == cards.size() - 1) {
                    break;
                }
                String thisCardSuit = cards.get(startIndex).getSuit();
                String nextCardSuit = cards.get(startIndex + 1).getSuit();
                if (thisCardSuit.equals(nextCardSuit)) {
                    counter++;
                    startIndex++;
                } else {
                    break;
                }
            }
            for (int j = i; j < i + counter; j++) {
                sum += cards.get(j).getPower() * counter;
            }
            if(counter>1){
                i += counter - 1;
            }
        }
    }

    private static void fillCardsList() {
        for (String s : inputList) {
            int cardPower = 0;
            String cardSuit = "" + s.charAt(s.length() - 1);
            String inputPower = "";
            if (s.startsWith("10")) {
                inputPower = "10";
            } else {
                inputPower = "" + s.charAt(0);
            }

            switch (inputPower) {
                case "2":
                    cardPower = 2;
                    break;
                case "3":
                    cardPower = 3;
                    break;
                case "4":
                    cardPower = 4;
                    break;
                case "5":
                    cardPower = 5;
                    break;
                case "6":
                    cardPower = 6;
                    break;
                case "7":
                    cardPower = 7;
                    break;
                case "8":
                    cardPower = 8;
                    break;
                case "9":
                    cardPower = 9;
                    break;
                case "10":
                    cardPower = 10;
                    break;
                case "J":
                    cardPower = 12;
                    break;
                case "Q":
                    cardPower = 13;
                    break;
                case "K":
                    cardPower = 14;
                    break;
                case "A":
                    cardPower = 15;
                    break;
            }
            Card newCard = new Card();
            newCard.setPower(cardPower);
            newCard.setSuit(cardSuit);
            cards.add(newCard);
        }
    }

    public static class Card {
        private int power;
        private String suit;

        public Card() {
        }

        public Card(int power, String suit) {
            this.power = power;
            this.suit = suit;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

        public String getSuit() {
            return suit;
        }

        public void setSuit(String suit) {
            this.suit = suit;
        }
    }

}
