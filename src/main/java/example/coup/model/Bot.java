package example.coup.model;

import example.coup.game.Game;

public class Bot extends Player{

    public Bot(String name) {
        super(name,"");
    }
    public Player choosePlayer(Game game){
        return game.player[(game.turn + 1)%4];
    }
    public String chooseCard(){
        return hand.get(0);
    }

}
