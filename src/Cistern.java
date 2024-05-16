import java.util.ArrayList;
import java.util.List;

class Cistern extends ActiveElement {
    private int waterReached;
    private List<PipeElement> pipeElements;

    public Cistern() {
        super("cistern");
        this.waterReached = 0;
        pipeElements = new ArrayList<>();
    }

    @Override public void print()
    {
        System.out.println("Type: " + type);
        System.out.println("Water reached: "+ waterReached);
        for(Player player: this.player)
        {
            if(player != null)
            System.out.println("Player here, id:" + player.getPlayerid());
        }
        System.out.println();
    }

    public Pump manufacturePump() throws Exception {
        Pump pump = new Pump(true, 10, null, null, null);
        pipeElements.add(pump);
        return pump;
    }

    public Pipe manufacturePipe() {
        ActiveElement newPipeEnds[] = new ActiveElement[2];
        newPipeEnds[0] = this;
        newPipeEnds[1] = null;
        Pipe newPipe = new Pipe(false, 100, 20, newPipeEnds);
        return newPipe;
    }

    public int getWaterReached() {
        System.out.println("getWaterReached()");
        return waterReached;
    }

    public List<PipeElement> getPipeElements() {
        System.out.println("getPipeElements()");
        return pipeElements;

    }

    public void setWaterReached(int waterReached) {
        this.waterReached = waterReached;
        System.out.println("setWaterReached(int waterReached)");
    }

    public void setPipeElements(List<PipeElement> pipeElements) {
        this.pipeElements = pipeElements;
        System.out.println("setPipeElements(List<PipeElement> pipeElements)");
    }

}