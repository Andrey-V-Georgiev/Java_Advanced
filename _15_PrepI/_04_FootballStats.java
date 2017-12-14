package _15_PrepI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _04_FootballStats {
    static HashMap<String, List<Event>> events;

    public static void main(String[] args) throws IOException {
        events = new HashMap<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //fill the events
        String input = bf.readLine();
        while (!"Season End".equals(input)) {
            String regex = "(-|result|:)";
            String[] tokens = input.split(regex);
            String teamName = tokens[0].trim();
            String opponentName = tokens[1].trim();
            int teamGoals = Integer.parseInt(tokens[2].trim());
            int opponentGoals = Integer.parseInt(tokens[3].trim());
            Event newEvent = new Event();
            newEvent.setOpponentName(opponentName);
            newEvent.setTeamGoals(teamGoals);
            newEvent.setOpponentGoals(opponentGoals);
            if (events.containsKey(teamName)) {
                events.get(teamName).add(newEvent);
            } else {
                events.put(teamName, new ArrayList<>(Arrays.asList(newEvent)));
            }
            Event oppositeEvent = new Event();
            oppositeEvent.setOpponentName(teamName);
            oppositeEvent.setTeamGoals(opponentGoals);
            oppositeEvent.setOpponentGoals(teamGoals);
            if (events.containsKey(opponentName)) {
                events.get(opponentName).add(oppositeEvent);
            } else {
                events.put(opponentName, new ArrayList<>(Arrays.asList(oppositeEvent)));
            }
            input = bf.readLine();
        }
        //receive the sequence of output
        String[] sequence = bf.readLine().split(", ");
        //print the results
        for (String team : sequence) {
            events.get(team).stream()
                    .sorted((x, y) -> x.getOpponentName().compareTo(y.getOpponentName()))
                    .forEach(e -> System.out.printf("%s - %s -> %d:%d%n", team, e.getOpponentName(), e.getTeamGoals(), e.getOpponentGoals()));
        }
    }

    static class Event {
        private String opponentName;
        private int teamGoals;
        private int opponentGoals;

        public Event() {
        }

        public Event(String opponentName, int teamGoals, int opponentGoals) {
            this.opponentName = opponentName;
            this.teamGoals = teamGoals;
            this.opponentGoals = opponentGoals;
        }

        public String getOpponentName() {
            return opponentName;
        }

        public void setOpponentName(String opponentName) {
            this.opponentName = opponentName;
        }

        public int getTeamGoals() {
            return teamGoals;
        }

        public void setTeamGoals(int teamGoals) {
            this.teamGoals = teamGoals;
        }

        public int getOpponentGoals() {
            return opponentGoals;
        }

        public void setOpponentGoals(int opponentGoals) {
            this.opponentGoals = opponentGoals;
        }
    }
}
