package example.coup.gui;

import example.coup.HelloApplication;
import example.coup.game.Game;
import example.coup.model.Player;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GameSceneController {

    public ListView actionsListView;

    public ImageView yourCoin6;
    public ImageView yourCoin7;
    public ImageView yourCoin8;
    public ImageView yourCoin9;
    public ImageView yourCoin10;
    public ImageView yourCoin1;
    public ImageView yourCoin2;
    public ImageView yourCoin3;
    public ImageView yourCoin4;
    public ImageView yourCoin5;
    public ImageView firstBotsCoin6;
    public ImageView firstBotsCoin7;
    public ImageView firstBotsCoin8;
    public ImageView firstBotsCoin9;
    public ImageView firstBotsCoin10;
    public ImageView firstBotsCoin1;
    public ImageView firstBotsCoin2;
    public ImageView firstBotsCoin3;
    public ImageView firstBotsCoin4;
    public ImageView firstBotsCoin5;
    public ImageView secondBotsCoin6;
    public ImageView secondBotsCoin7;
    public ImageView secondBotsCoin8;
    public ImageView secondBotsCoin9;
    public ImageView secondBotsCoin10;
    public ImageView secondBotsCoin1;
    public ImageView secondBotsCoin2;
    public ImageView secondBotsCoin3;
    public ImageView secondBotsCoin4;
    public ImageView secondBotsCoin5;
    public ImageView thirdBotsCoin6;
    public ImageView thirdBotsCoin7;
    public ImageView thirdBotsCoin8;
    public ImageView thirdBotsCoin9;
    public ImageView thirdBotsCoin10;
    public ImageView thirdBotsCoin1;
    public ImageView thirdBotsCoin2;
    public ImageView thirdBotsCoin3;
    public ImageView thirdBotsCoin4;
    public ImageView thirdBotsCoin5;
    public ChoiceBox actionChoiceBox;
    public Button performActionButton;
    public Button challengeAttackerButton;
    public Button confrontButton;
    public ChoiceBox opponentChoiceBox;
    public Button challengeDefenderButton;
    public Button doNothingButton;
    public Button nextRoundButton;
    public GridPane DeskCards;
    public GridPane HumanCard;
    public GridPane FirstBotGrid;
    public GridPane SecondBotGrid;
    public GridPane ThirdBotGrid;
    Image Ambassador1 = new Image(String.valueOf(HelloApplication.class.getResource("Ambassador.png")));
//    Image Ambassador2 = new Image(String.valueOf(HelloApplication.class.getResource("Ambassador.png")));
//    Image Ambassador3 = new Image(String.valueOf(HelloApplication.class.getResource("Ambassador.png")));
    Image Assassin1 = new Image(String.valueOf(HelloApplication.class.getResource("Assassin.png")));
//    Image Assassin2 = new Image(String.valueOf(HelloApplication.class.getResource("Assassin.png")));
//    Image Assassin3 = new Image(String.valueOf(HelloApplication.class.getResource("Assassin.png")));
    Image Captain1 = new Image(String.valueOf(HelloApplication.class.getResource("Captain.png")));
//    Image Captain2 = new Image(String.valueOf(HelloApplication.class.getResource("Captain.png")));
//    Image Captain3 = new Image(String.valueOf(HelloApplication.class.getResource("Captain.png")));
    Image Duke1 = new Image(String.valueOf(HelloApplication.class.getResource("Duke.png")));
//    Image Duke2 = new Image(String.valueOf(HelloApplication.class.getResource("Duke.png")));
//    Image Duke3 = new Image(String.valueOf(HelloApplication.class.getResource("Duke.png")));
    Image Countess1 = new Image(String.valueOf(HelloApplication.class.getResource("Contessa.png")));
//    Image Countess2 = new Image(String.valueOf(HelloApplication.class.getResource("Contessa.png")));
//    Image Countess3 = new Image(String.valueOf(HelloApplication.class.getResource("Contessa.png")));

    Game game;
    Player player1 = new Player("Parsa");
    Player player2 = new Player("Paranoid");
    Player player3 = new Player("CautiousKiller");
    Player player4 = new Player("Greedy");



    public void initialize(){
        game = new Game(player1, player2, player3, player4);
        game.start();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Pane pane = new Pane();
                pane.setId(String.valueOf(10 * j + i));
                pane.getStyleClass().removeAll();
                
                if(i == 0){
                    ImageView imageView = new ImageView(Ambassador1);
                    imageView.setFitHeight(50);
                    imageView.setFitWidth(50);
                    pane.getChildren().add(imageView);
                }
//                else if(i == 0 && j == 1){
//                    ImageView imageView = new ImageView(Ambassador2);
//                    imageView.setFitHeight(50);
//                    imageView.setFitWidth(50);
//                    pane.getChildren().add(imageView);
//                }
//                else if(i == 0 && j == 2){
//                    ImageView imageView = new ImageView(Ambassador3);
//                    imageView.setFitHeight(50);
//                    imageView.setFitWidth(50);
//                    pane.getChildren().add(imageView);
//                }
                else if(i == 1){
                    ImageView imageView = new ImageView(Assassin1);
                    imageView.setFitHeight(50);
                    imageView.setFitWidth(50);
                    pane.getChildren().add(imageView);
                }
//                else if(i == 1 && j == 1){
//                    ImageView imageView = new ImageView(Assassin2);
//                    imageView.setFitHeight(50);
//                    imageView.setFitWidth(50);
//                    pane.getChildren().add(imageView);
//                }
//                else if(i == 1 && j == 2){
//                    ImageView imageView = new ImageView(Assassin3);
//                    imageView.setFitHeight(50);
//                    imageView.setFitWidth(50);
//                    pane.getChildren().add(imageView);
//                }
                else if(i == 2){
                    ImageView imageView = new ImageView(Countess1);
                    imageView.setFitHeight(50);
                    imageView.setFitWidth(50);
                    pane.getChildren().add(imageView);
                }
//                else if(i == 2 && j == 1){
//                    ImageView imageView = new ImageView(Countess2);
//                    imageView.setFitHeight(50);
//                    imageView.setFitWidth(50);
//                    pane.getChildren().add(imageView);
//                }
//                else if(i == 2 && j == 2){
//                    ImageView imageView = new ImageView(Countess3);
//                    imageView.setFitHeight(50);
//                    imageView.setFitWidth(50);
//                    pane.getChildren().add(imageView);
//                }
                else if(i == 3){
                    ImageView imageView = new ImageView(Captain1);
                    imageView.setFitHeight(50);
                    imageView.setFitWidth(50);
                    pane.getChildren().add(imageView);
                }
//                else if(i == 3 && j == 1){
//                    ImageView imageView = new ImageView(Captain2);
//                    imageView.setFitHeight(50);
//                    imageView.setFitWidth(50);
//                    pane.getChildren().add(imageView);
//                }
//                else if(i == 3 && j == 2){
//                    ImageView imageView = new ImageView(Captain3);
//                    imageView.setFitHeight(50);
//                    imageView.setFitWidth(50);
//                    pane.getChildren().add(imageView);
//                }
                else if(i == 4){
                    ImageView imageView = new ImageView(Duke1);
                    imageView.setFitHeight(50);
                    imageView.setFitWidth(50);
                    pane.getChildren().add(imageView);
                }
//                else if(i == 4 && j == 1){
//                    ImageView imageView = new ImageView(Duke2);
//                    imageView.setFitHeight(50);
//                    imageView.setFitWidth(50);
//                    pane.getChildren().add(imageView);
//                }
//                else if(i == 4 && j == 2){
//                    ImageView imageView = new ImageView(Duke3);
//                    imageView.setFitHeight(50);
//                    imageView.setFitWidth(50);
//                    pane.getChildren().add(imageView);
//                }
                
                
                
            }
        }

        







    }
}