package controller;

import model.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        System.out.println("=== DEMO ALL FEATURES ===");

        game.runScript("""
    print

    move right
    move down
    print

    attack

    aggressive
    attack

    move right
    print
    attack

    repeat 2 {
        move left
        print
        attack
    }
    
    kuy
""");


    }
}
