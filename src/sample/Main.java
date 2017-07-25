package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Font.loadFont(getClass().getResourceAsStream("/res/digital-7.ttf"),20);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lit Clock");
        Scene scene = new Scene(root, 350, 380);

        scene.getStylesheets().add("/css/font.css");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(350);
        primaryStage.setMinHeight(380);
        primaryStage.setMaxHeight(380);
        primaryStage.setMaxWidth(350);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}