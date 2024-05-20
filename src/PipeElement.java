import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class PipeElement {

    protected List<Player> player;
    public String type;

    public PipeElement(String type) {
        player = new ArrayList<>();
        this.type = type;
    }

    public boolean acceptPlayer(Player player) {
        System.out.println("acceptPlayer(Player player)");
        if(Objects.equals(type, "pipe"))
        {
            if(this.player.size() >0)
            {
                System.out.println("Cannot move player here. It is a pipe, and already someone is here.");
                return false;
            }
        }
        this.player.add(player);
        return true;
    }

    public void removePlayer(Player player) {
        System.out.println("removePlayer(Player player)");
        this.player.remove(player);
    }

    public List<Player> getPlayers() {
        System.out.println("getPlayers()");
        return player;
    }

    public void print(){
    }
}