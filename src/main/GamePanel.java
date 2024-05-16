package main;

import Entity.Plumber;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;
    //setting a single tile size by scaling it
    public final int tileSize = originalTileSize*scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    //setting the width of screen and tilling itaw
    public final int screenWidth = tileSize * maxScreenCol;
    //setting the height of screen and tilling it
    final int screenHeight = tileSize * maxScreenRow;
    //FPS
    int FPS = 60;
    TileManager tileManager = new TileManager(this);
    Thread gameThread; //running the game on this thread
    KeyHandler keyHandler = new KeyHandler();
    Plumber plumber = new Plumber(this,keyHandler);
    //set player's default position
    int plumberX = 100;
    int plumberY = 100;
    int playerSpeed = 4;
    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start(); //starting the game thread
    }
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; //0.0666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread!=null)
        {

            Update();
            repaint();
            try {
                double remainingtime = nextDrawTime - System.nanoTime();
                remainingtime = remainingtime /1000000; 
                if(remainingtime < 0){
                    remainingtime = 0;
                }
                Thread.sleep((long) remainingtime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void Update(){
    plumber.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileManager.draw(g2);
        plumber.draw(g2);
        g2.dispose();

    }
}
