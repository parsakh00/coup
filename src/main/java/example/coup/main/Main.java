package example.coup.main;

import example.coup.game.Game;
import example.coup.game.GameConfig;
import example.coup.model.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        GameConfig gameConfig1 = new GameConfig();
//        GameConfig gameConfig2 = new GameConfig();
//        GameConfig gameConfig3 = new GameConfig();
//        GameConfig gameConfig4 = new GameConfig();
//        Game game = new Game(gameConfig1.getPlayer(),gameConfig2.getPlayer(),gameConfig3.getPlayer(),gameConfig4.getPlayer());
        Player player1 = new Player("user1");
        Player player2 = new Player("user2");
        Player player3 = new Player("user3");
        Player player4 = new Player("user4");
        Game game = new Game(player1, player2, player3, player4);
        game.start();

    }



}
