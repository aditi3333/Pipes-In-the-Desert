class Plumberold extends Player {
    public Plumberold(int playerId, int teamId)
    {
        super(playerId,teamId);
    }

    public void fixPipe(Pipe pipe) {
        // Method to fix a pipe
        System.out.println("fixPipe(Pipe pipe)");
        pipe.setLeaking(false);
    }

    public void fixPump(Pump pump) {
        System.out.println("fixPump(Pump pump2)");
        pump.fixPump();
    }

    public void insertPump(Pipe pipe, Pump pump) {
        // Method to insert a pump into a pipe
        System.out.println("insertPump() ");
        pipe.splitPipe(pump);
    }

    public void pickElement(PipeElement element) {
        // Method to pick an element from the pipe
        System.out.println("pickElement(PipeElement element)");
    }

    public void insertPipe(Pipe pipe) {
        // Method to insert a pipe into another pipe
        System.out.println("insertPipe(Pipe pipe)");
    }

    public Pump manufacturePump(Cistern cistern) throws Exception {
        // Method to manufacture a pump
        System.out.println("manufacturePump()");
        return cistern.manufacturePump();
    }

    public Pipe manufacturePipe(Cistern cistern) {
        // Method to manufacture a pipe
        System.out.println("manufacturePipe()");
        return cistern.manufacturePipe();
    }
}