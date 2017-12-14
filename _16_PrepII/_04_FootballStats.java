package _16_PrepII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _04_FootballStats {
    static HashMap<String, List<Game>> allGames = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        while(!"Season End".equals(input)){
            String[] currentLine = input.split(" - | result ");
            String teamName = currentLine[0].trim();
            String opponentName = currentLine[1].trim();
            String[] currentResult = currentLine[2].trim().split(":");
            int teamScore = Integer.parseInt(currentResult[0]);
            int opponentScore = Integer.parseInt(currentResult[1]);

            Game teamGame = new Game();
            teamGame.setOpponent(opponentName);
            teamGame.setTeamScore(teamScore);
            teamGame.setOpponentScore(opponentScore);

            if(allGames.containsKey(teamName)){
                allGames.get(teamName).add(teamGame);
            }else{
                allGames.put(teamName, new ArrayList<>(Arrays.asList(teamGame)));
            }

            Game opponentGame = new Game();
            opponentGame.setOpponent(teamName);
            opponentGame.setTeamScore(opponentScore);
            opponentGame.setOpponentScore(teamScore);

            if(allGames.containsKey(opponentName)){
                allGames.get(opponentName).add(opponentGame);
            }else{
                allGames.put(opponentName, new ArrayList<>(Arrays.asList(opponentGame)));
            }

            input = bf.readLine();
        }



        String[] printSequence = bf.readLine().split(", ");
        for (String s : printSequence) {
            allGames.get(s).stream().sorted((a,b)-> a.getOpponent().compareTo(b.getOpponent()))
                    .forEach(x-> System.out.printf(
                            "%s - %s -> %d:%d%n",s,x.getOpponent(),x.getTeamScore(),x.getOpponentScore()));
        }
    }

    static class Game{
        private String opponent;
        private int teamScore;
        private int opponentScore;

        public Game() {
        }

        public Game(String opponent, int teamScore, int opponentScore) {
            this.opponent = opponent;
            this.teamScore = teamScore;
            this.opponentScore = opponentScore;
        }

        public String getOpponent() {
            return opponent;
        }

        public void setOpponent(String opponent) {
            this.opponent = opponent;
        }

        public int getTeamScore() {
            return teamScore;
        }

        public void setTeamScore(int teamScore) {
            this.teamScore = teamScore;
        }

        public int getOpponentScore() {
            return opponentScore;
        }

        public void setOpponentScore(int opponentScore) {
            this.opponentScore = opponentScore;
        }
    }
}
