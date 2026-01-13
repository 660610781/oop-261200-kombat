package model;

public class Game {
    private int turn = 1;

    public void nextTurn() {
        System.out.println("Turn " + turn);
        turn++;
    }
}
