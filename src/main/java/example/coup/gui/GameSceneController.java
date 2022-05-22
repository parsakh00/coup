package example.coup.gui;

import example.coup.HelloApplication;
import example.coup.game.Game;
import example.coup.model.Action;
import example.coup.model.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Objects;

public class GameSceneController {

    public ListView actionsListView;
    public ChoiceBox<Action> actionChoiceBox;
    public ChoiceBox<String> challengeChoiceBox;

    private final Action[] ACTION_LIST = {Action.Income,Action.ForeignAid,Action.Coup
            ,Action.Taxes,Action.Assassinate,Action.Steal,Action.SwapInfluence};
    private final ObservableList<Action> ACTION = FXCollections.observableArrayList(ACTION_LIST);

    private final String[] CHALLENGE_LIST = {"No Challenge","FirstBot","SecondBot","ThirdBot"};
    private final ObservableList<String> CHALLENGE = FXCollections.observableArrayList(CHALLENGE_LIST);


    public GridPane DeskCards;
    public GridPane HumanCard;
    public GridPane FirstBotGrid;
    public GridPane SecondBotGrid;
    public GridPane ThirdBotGrid;
    public ImageView userCoin;
    public ImageView firstBotCoin;
    public ImageView secondBotCoin;
    public ImageView thirdBotCoin;
    public Label userCoins;
    public Label firstBotCoins;
    public Label thirdBotCoins;
    public Label secondBotCoins;
    public Label gameCoin;
    public Button nextRound;
    public Button okAction;
    public Button okChallenge;

    int eachCardNumber;
    Image Ambassador1 = new Image(String.valueOf(HelloApplication.class.getResource("Ambassador.png")));
    Image Assassin1 = new Image(String.valueOf(HelloApplication.class.getResource("Assassin.png")));
    Image Captain1 = new Image(String.valueOf(HelloApplication.class.getResource("Captain.png")));
    Image Duke1 = new Image(String.valueOf(HelloApplication.class.getResource("Duke.png")));
    Image Countess1 = new Image(String.valueOf(HelloApplication.class.getResource("Contessa.png")));
    Game game;
    int cnt;
    Player player1 = new Player("Parsa","user");
    Player player2 = new Player("Paranoid","FirstBot");
    Player player3 = new Player("CautiousKiller","SecondBot");
    Player player4 = new Player("Greedy","ThirdBot");

//    ArrayList<String> userCards;
//    userCards = new ArrayList<>();
//    desk = (ArrayList<String>) getDeskFile();

    public void initialize(){
        game = new Game(player1, player2, player3, player4);
        game.start();

        arrangeDesk();
        arrangeHands();
        putUsersCoin();
        putGameCoin();

        actionChoiceBox.setItems(ACTION);
        challengeChoiceBox.setItems(CHALLENGE);


    }

    public Player getUserPlayer(){
        for (int i = 0; i < 4; i++){
            if (Objects.equals(game.player[i].getBotNumber(), "user")) return game.player[i];
        }
        return null;
    }

    public void challengeBtn(ActionEvent actionEvent){
        //ToDO
    }
    public void actionBtn(ActionEvent actionEvent){
        if(actionChoiceBox.getSelectionModel().getSelectedItem() == Action.Income) getUserPlayer().addCoin(1);
        //ToDo
    }
    public void nextRoundBtn(ActionEvent actionEvent){
        //ToDo
    }

    public void putUsersCoin(){
        for (int i = 0; i < 4; i++){
            String botNumber = getUserBotNumberFile(game.player[i]);
            int usersCoin = getUserCoinFromFile(game.player[i]);
            switch (botNumber) {
                case "FirstBot" -> firstBotCoins.setText(Integer.toString(usersCoin));
                case "SecondBot" -> secondBotCoins.setText(Integer.toString(usersCoin));
                case "ThirdBot" -> thirdBotCoins.setText(Integer.toString(usersCoin));
                default -> userCoins.setText(Integer.toString(usersCoin));
            }
        }
    }
    public void putGameCoin(){
        gameCoin.setText(Integer.toString(game.coin));
    }
    public void arrangeHands(){
        //for each player hand
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 2; i++) {
                Pane pane = new Pane();
                pane.setId(String.valueOf(i));
                pane.getStyleClass().removeAll();
                //String userName = getUserNameFromFile(game.player[j]);
                String botNumber = getUserBotNumberFile(game.player[j]);
                String handCardName = getUserCardsFromFile(game.player[j], i);
                switch (botNumber) {
                    case "FirstBot" -> {
                        pane.getChildren().add(getImageOfCard(handCardName));
                        FirstBotGrid.add(pane, i, 0, 1, 1);
                    }
                    case "SecondBot" -> {
                        pane.getChildren().add(getImageOfCard(handCardName));
                        SecondBotGrid.add(pane, i, 0, 1, 1);
                    }
                    case "ThirdBot" -> {
                        pane.getChildren().add(getImageOfCard(handCardName));
                        ThirdBotGrid.add(pane, i, 0, 1, 1);
                    }
                    default -> {
                        pane.getChildren().add(getImageOfCard(handCardName));
                        HumanCard.add(pane, i, 0, 1, 1);
                    }
                }
            }
        }
    }

    public void arrangeDesk(){
        for (int i = 0; i < 5; i++) {
            if(i == 0){
                cnt = numberOfEachCardInDesk(game.desk, "Ambassador");
                for (int j = 0; j < 3; j++) {
                    if (cnt > 0) {
                        Pane pane = new Pane();
                        pane.setId(String.valueOf(10 * j + i));
                        pane.getStyleClass().removeAll();
                        pane.getChildren().add(getImageOfCard("Ambassador"));
                        DeskCards.add(pane, i, j, 1, 1);
                    }
                    cnt -= 1;
                }
            }
            else if(i == 1){
                for (int j = 0; j < 3; j++) {
                    if (cnt > 0) {
                        Pane pane = new Pane();
                        pane.setId(String.valueOf(10 * j + i));
                        pane.getStyleClass().removeAll();
                        pane.getChildren().add(getImageOfCard("Assassin"));
                        DeskCards.add(pane, i, j, 1, 1);
                    }
                    cnt -= 1;
                }
            }
            else if(i == 2){
                for (int j = 0; j < 3; j++) {
                    if (cnt > 0) {
                        Pane pane = new Pane();
                        pane.setId(String.valueOf(10 * j + i));
                        pane.getStyleClass().removeAll();
                        pane.getChildren().add(getImageOfCard("Countess"));
                        DeskCards.add(pane, i, j, 1, 1);
                    }
                    cnt -= 1;
                }
            }
            else if(i == 3){
                for (int j = 0; j < 3; j++) {
                    if (cnt > 0) {
                        Pane pane = new Pane();
                        pane.setId(String.valueOf(10 * j + i));
                        pane.getStyleClass().removeAll();
                        pane.getChildren().add(getImageOfCard("Captain"));
                        DeskCards.add(pane, i, j, 1, 1);
                    }
                    cnt -= 1;
                }
            }
            else {
                for (int j = 0; j < 3; j++) {
                    if (cnt > 0) {
                        Pane pane = new Pane();
                        pane.setId(String.valueOf(10 * j + i));
                        pane.getStyleClass().removeAll();
                        pane.getChildren().add(getImageOfCard("Duke"));
                        DeskCards.add(pane, i, j, 1, 1);
                    }
                    cnt -= 1;
                }
            }

        }
    }
    public ImageView getImageOfCard(String cardName){
        if (Objects.equals(cardName, "Duke")){
            ImageView imageView = new ImageView(Duke1);
            imageView.setFitHeight(50);
            imageView.setFitWidth(50);
            return imageView;
        }
        else if (Objects.equals(cardName, "Assassin")){
            ImageView imageView = new ImageView(Assassin1);
            imageView.setFitHeight(50);
            imageView.setFitWidth(50);
            return imageView;
        }
        else if (Objects.equals(cardName, "Countess")){
            ImageView imageView = new ImageView(Countess1);
            imageView.setFitHeight(50);
            imageView.setFitWidth(50);
            return imageView;
        }
        else if (Objects.equals(cardName, "Captain")){
            ImageView imageView = new ImageView(Captain1);
            imageView.setFitHeight(50);
            imageView.setFitWidth(50);
            return imageView;
        }
        else {
            ImageView imageView = new ImageView(Ambassador1);
            imageView.setFitHeight(50);
            imageView.setFitWidth(50);
            return imageView;
        }
    }


    public int numberOfEachCardInDesk(ArrayList<String> desk,String cardName){
        eachCardNumber = 0;
        for (String element:desk){
            if(Objects.equals(element, cardName)) eachCardNumber += 1;
        }
        return eachCardNumber;
    }
    public String getUserCardsFromFile(Player player, int i){
        try {

            //Read JSON file
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\example\\coup\\database\\" + player.getName() + ".json"));
            JSONObject deskCards = (JSONObject) obj;


            return ((ArrayList<String>) deskCards.get("Cards")).get(i);

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int getUserCoinFromFile(Player player){
        try {

            //Read JSON file
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\example\\coup\\database\\" + player.getName() + ".json"));
            JSONObject deskCards = (JSONObject) obj;


            return (int) deskCards.get("Coin");

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public String getUserBotNumberFile(Player player){
        try {

            //Read JSON file
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\example\\coup\\database\\" + player.getName() + ".json"));
            JSONObject deskCards = (JSONObject) obj;


            return (String) deskCards.get("BotNumber");

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}