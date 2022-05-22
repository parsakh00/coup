package example.coup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/GameScene.fxml"));
        Image icon = new Image(String.valueOf(HelloApplication.class.getResource("logo.jpg")));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setOnCloseRequest(event ->{
            event.consume();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("close window");
            alert.setHeaderText("confirmation");
            alert.setContentText("Quit Game ?");
            Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
            alertStage.getIcons().add(new Image(String.valueOf(HelloApplication.class.getResource("logo.jpg"))));
            if (alert.showAndWait().get() == ButtonType.OK){
                stage.close();
            }
        });

        stage.getIcons().add(icon);
        stage.setTitle("Coup Game");
        stage.setHeight(800);
        stage.setWidth(800);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}