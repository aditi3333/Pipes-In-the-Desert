class Saboteur extends Player {
    public Saboteur(int playerId, int teamId)
    {
        super(playerId,teamId);
    }

    public void puncturePipe(Pipe pipe) {
        // Method to puncture a pipe
        System.out.println("puncturePipe(Pipe pipe)");
        System.out.println("isLeaking == true");
        pipe.setLeaking(true);
    }

    public void breakPump(Pump pump) {
        // Method to break a pump
        System.out.println("breakPump(Pump pump)");
        System.out.println("works = false");
        System.out.println("Success: Pump is broken now");
        pump.breakPump();
    }
}