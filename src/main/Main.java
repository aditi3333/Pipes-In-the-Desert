package main;

import main.GamePanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    Scanner scanner;

    int plumberTeamId =0;
    int saboteurTeamId = 1;
    int plumberPositionIndex = 0;
    int saboteurPositionIndex = 4;


    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Pipes in Desert");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }




    /**
     * displayMenu displays the main menu
     */
    private static void displayMenu() {
        System.out.println("Enter your choice:");
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
        System.out.print("Choose an option: ");
    }

    /**
     * playGame
     */



}