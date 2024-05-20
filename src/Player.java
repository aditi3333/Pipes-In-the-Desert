import main.Directions;

class Player {
    private final int playerId;
    private int teamId;

    public Player(int playerId, int teamId) {
        this.playerId = playerId;
        this.teamId = teamId;
    }

    public int getPlayerid()
    {
        return playerId;
    }

    public int getTeamId()
    {
        return teamId;
    }

    public void move(Directions direction) {

        // Method to move the player in a given direction
        System.out.println("move(Direction direction)");
    }

    public void changePumpDirection(Pump pump, Pipe inPipe, Pipe outPipe) throws Exception {
        // Method to change the direction of the pump
        System.out.println("changePumpDirection(Pump pump, Pipe inPipe, Pipe outPipe)");
        pump.changeDirection(inPipe, outPipe);
    }

    public void selectTeam(int teamId) {
        this.teamId = teamId;
        System.out.println("selectTeam(int teamId)");
    }
}