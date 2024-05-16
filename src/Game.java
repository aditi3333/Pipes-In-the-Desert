import java.util.HashMap;
import java.util.Map;

class Game {
    private boolean gameStarted;
    private boolean gameEnded;
    private Map<Integer, Integer> plumberTeamMap; // Maps playerID to teamID for plumbers
    private Map<Integer, Integer> saboteurTeamMap; // Maps playerID to teamID for saboteurs

    public Game() {
        gameStarted = false;
        gameEnded = false;
        plumberTeamMap = new HashMap<>();
        saboteurTeamMap = new HashMap<>();
    }

    public void startGame() {
        if (!gameStarted) {
            gameStarted = true;
            // Perform game initialization tasks
            System.out.println(" startGame() ");

        }
    }

    public void endGame() {
        if (gameStarted && !gameEnded) {
            System.out.println("endGame()");
            gameEnded = true;
            // Perform end game tasks

        }
    }

    public void concludeResults() {
        // Method to conclude game results
        System.out.println("concludeResults()");

    }

    public void assignPlumberTeam(int playerId, int teamId) {
        plumberTeamMap.put(playerId, teamId);
        System.out.println("assignPlumberTeam(int playerId, int teamId)");
    }

    public void assignSaboteurTeam(int playerId, int teamId) {
        saboteurTeamMap.put(playerId, teamId);
        System.out.println("assignSaboteurTeam(int playerId, int teamId)");
    }
}
