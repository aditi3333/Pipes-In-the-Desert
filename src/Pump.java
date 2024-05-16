import java.util.ArrayList;
import java.util.List;

class Pump extends ActiveElement {
    private boolean works;
    private Pipe incomingPipe;
    private Pipe outgoingPipe;
    private List<Pipe> connectedPipes;
    private int maxPipes;

    public Pump(boolean works, int maxPipes, List<Pipe> connectedPipes, Pipe incomingPipe, Pipe outgoingPipe)throws Exception {
        super("pump");
        this.works = works;
        this.maxPipes = maxPipes;
        if(connectedPipes == null)
        {
            this.connectedPipes = new ArrayList<>();
            if(incomingPipe != null || outgoingPipe != null)
            {
                throw new Exception("If connected pipes is null, then so must be incoming and outgoing pipe.");
            }
            this.incomingPipe = null;
            this.outgoingPipe = null;
            return;
        }
        assert connectedPipes != null;
        if (connectedPipes.size() > maxPipes) {
            throw new Exception("connectedPipes can not have more pipes than maxPipes.");
        }
        this.connectedPipes = connectedPipes;
        if(!connectedPipes.contains(incomingPipe) || !connectedPipes.contains(outgoingPipe))
        {
            throw new Exception("incoming and outgoing pipes must be in connecting pipes.");
        }
        this.incomingPipe = incomingPipe;
        this.outgoingPipe = outgoingPipe;
    }

    public void addPipe(Pipe pipe)
    {
        if(connectedPipes.size() < maxPipes)
        connectedPipes.add(pipe);
        else
        {
            System.out.println("Cannot add new pipe to pump.");
        }
    }

    @Override public void print()
    {
        System.out.println("Type: " + type);
        System.out.println("Works: "+ works);
        System.out.println("max pipes: "+ maxPipes);
        for(Player player: this.player)
        {
            if(player != null)
            System.out.println("Player here, id:" + player.getPlayerid());
        }
        System.out.println();
    }

    public void changeDirection(Pipe in, Pipe out)throws Exception {
        System.out.println("changeDirection(Pipe in, Pipe out)");
        if( !connectedPipes.contains(in) || !connectedPipes.contains(out) )
        {
            throw new Exception("Input or Output pipe not found in connected pipes.");
        }
        this.incomingPipe = in;
        this.outgoingPipe = out;
    }

    public void breakPump() {
        works=false;
        System.out.println("breakPump()");
    }

    public void fixPump() {
        works=true;
        System.out.println("fixPump()");
    }

    public void pullWater() {
        System.out.println("pullWater()");
    }

    public void pushWater() {
        System.out.println("pushWater()");
    }

    public void setIncomingPipe(Pipe incomingPipe)
    {
        this.incomingPipe=incomingPipe;
        System.out.println("setIncomingPipe(Pipe incomingPipe)");
    }

    public void setOutgoingPipe(Pipe outgoingPipe)
    {
        this.outgoingPipe=outgoingPipe;
        System.out.println("setOutgoingPipe(Pipe outgoingPipe)");
    }
}