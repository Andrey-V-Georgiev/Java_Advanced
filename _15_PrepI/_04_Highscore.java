package _15_PrepI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _04_Highscore {
    static LinkedHashMap<String, Player> players = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        String regex = "(\\s|<->)";
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(regex);

        while (!"osu!".equals(input[0])) {
            if("".equals(input[0])){
                return;
            }
            //read the line
            long scoreFirstPlayer = Long.parseLong(input[0]);
            String firstPlayerName = input[1];
            String secondPlayerName = input[2];
            long scoreSecondPlayer = Long.parseLong(input[3]);

            //find the results
            long firstPlayerResult = scoreFirstPlayer - scoreSecondPlayer;
            long secondPlayerResult = scoreSecondPlayer - scoreFirstPlayer;

            //make the first player fight
            Fight firstPlayerFight = new Fight();
            firstPlayerFight.setOpponentName(secondPlayerName);
            firstPlayerFight.setCurrResult(firstPlayerResult);

            //make the second player fight
            Fight secondPlayerFight = new Fight();
            secondPlayerFight.setOpponentName(firstPlayerName);
            secondPlayerFight.setCurrResult(secondPlayerResult);

            //create first player
            Player newFirstPlayer = new Player();
            newFirstPlayer.setHighScore(firstPlayerResult);
            newFirstPlayer.setFights(new ArrayList(Arrays.asList(firstPlayerFight)));

            //create second player
            Player newSecondPlayer = new Player();
            newSecondPlayer.setHighScore(secondPlayerResult);
            newSecondPlayer.setFights(new ArrayList(Arrays.asList(secondPlayerFight)));

            //add or refresh first player
            if(players.containsKey(firstPlayerName)){
                players.get(firstPlayerName).setHighScore(players.get(firstPlayerName).getHighScore() + firstPlayerResult);
                List<Fight> firstPlayerAddFight = new ArrayList<>();
                firstPlayerAddFight.addAll(players.get(firstPlayerName).getFights());
                firstPlayerAddFight.add(firstPlayerFight);
                players.get(firstPlayerName).setFights(firstPlayerAddFight);
            } else {
               players.put(firstPlayerName, newFirstPlayer) ;
            }

            //add or refresh second player
            if(players.containsKey(secondPlayerName)){
                players.get(secondPlayerName).setHighScore(players.get(secondPlayerName).getHighScore() + secondPlayerResult);
                List<Fight> secondPlayerAddFight = new ArrayList<>();
                secondPlayerAddFight.addAll(players.get(secondPlayerName).getFights());
                secondPlayerAddFight.add(secondPlayerFight);
                players.get(secondPlayerName).setFights(secondPlayerAddFight);
            } else {
                players.put(secondPlayerName, newSecondPlayer);
            }


            input = bf.readLine().split(regex);
        }

        //print the results
        players.entrySet().stream()
                .sorted((b,a)-> Long.compare(a.getValue().getHighScore(), b.getValue().getHighScore()))
                .forEach(x -> {
                    System.out.printf("%s - (%d)%n",x.getKey(),x.getValue().getHighScore());

                    x.getValue().getFights().stream()
                            .forEach(f->System.out.printf("*   %s <-> %d%n",f.getOpponentName(),f.getCurrResult()));
                });

    }

    public static class Player {
        private long highScore;
        private List<Fight> fights;

        public Player() {
        }

        public Player(long highScore, List<Fight> fights) {
            this.highScore = highScore;
            this.fights = fights;
        }

        public long getHighScore() {
            return highScore;
        }

        public void setHighScore(long highScore) {
            this.highScore = highScore;
        }

        public List<Fight> getFights() {
            return fights;
        }

        public void setFights(List<Fight> fights) {
            this.fights = fights;
        }
    }

    public static class Fight {
        private String opponentName;
        private long currResult;

        public Fight() {
        }

        public Fight(String opponentName, long currResult) {
            this.opponentName = opponentName;
            this.currResult = currResult;
        }

        public String getOpponentName() {
            return opponentName;
        }

        public void setOpponentName(String opponentName) {
            this.opponentName = opponentName;
        }

        public long getCurrResult() {
            return currResult;
        }

        public void setCurrResult(long currResult) {
            this.currResult = currResult;
        }
    }
}
