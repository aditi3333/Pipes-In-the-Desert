class Spring extends ActiveElement {

    private int waterReleased;

    public Spring() {

        super("spring");
        this.waterReleased = 0;
    }

    @Override public void print()
    {
        System.out.println("Type: " + type);
        System.out.println("Water released: "+ waterReleased);
        for(Player player: this.player)
        {
            if(player != null)
            System.out.println("Player here, id:" + player.getPlayerid());
        }
        System.out.println();
    }

    public int getWaterReleased() {
        System.out.println("getWaterReleased()");
        return waterReleased;
    }

    public void increaseWaterReleased(int amount) {
        System.out.println("increaseWaterReleased(int amount)");
        this.waterReleased += waterReleased;
    }
}