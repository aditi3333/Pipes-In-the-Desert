class Pipe extends PipeElement{

    private boolean leaking;
    private int capacity;
    private int currentVolume;
    private boolean hasFreeEnd;
    private ActiveElement endElements[] = new ActiveElement[2];

    public Pipe(boolean leaking, int capacity, int currentVolume, ActiveElement[] endElements) {
        super("pipe");
        this.leaking = leaking;
        this.capacity = capacity;
        this.currentVolume = currentVolume;
        this.endElements[0] = endElements[0];
        this.endElements[1] = endElements[1];
        updateHasFreeEnd();
    }

    @Override public void print(){
        System.out.println("Type: " + type);
        System.out.println("Leaking: "+ leaking);
        System.out.println("Capacity: "+ capacity);
        System.out.println("Current volume: "+ currentVolume);
        if(endElements[0] != null)
        System.out.println("End1: "+endElements[0].type);
        if(endElements[1] != null)
        System.out.println("End2: "+endElements[1].type);
        if(this.player.size() > 0)
        {
            System.out.println("Player here, id:" + this.player.get(0).getPlayerid());
        }
        System.out.println();
    }

    private void updateHasFreeEnd()
    {
        System.out.println("updateHasFreeEnd()");
        if(this.endElements[0] != null && this.endElements[1] != null)
        {
            this.hasFreeEnd = false;
        }
        else
        {
            this.hasFreeEnd = true;
        }
    }

    public void changeEnd(ActiveElement e1, ActiveElement e2) {
        // Method to change the ends of the pipe
        System.out.println("changeEnd(ActiveElement e1, ActiveElement e2)");
        this.endElements[0] = e1;
        this.endElements[1] = e2;
        updateHasFreeEnd();
    }

    public Pipe splitPipe(Pump joiningPump) {
        // Method to split the pipe
        System.out.println("splitPipe(Pump joiningPump)");
        ActiveElement newPipeEnds[] = new ActiveElement[2];
        newPipeEnds[0] = joiningPump;
        newPipeEnds[1] = this.endElements[1];
        this.endElements[1] = joiningPump;
        Pipe newPipe = new Pipe(false, capacity, currentVolume, newPipeEnds);
        joiningPump.addPipe(this);
        joiningPump.addPipe(newPipe);
        return newPipe;
    }

    public void setLeaking(boolean leaking) {
        this.leaking = leaking;
        System.out.println("setLeaking(boolean leaking)");
    }

    public boolean getLeaking(){
        return this.leaking;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
        System.out.println("setCapacity(int capacity)");
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
        System.out.println("setCurrentVolume(int currentVolume)");
    }

    public boolean isHasFreeEnd() {
        return hasFreeEnd;
    }

    public ActiveElement[] getEndElements() {
        return endElements;
    }
}