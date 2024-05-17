package com.paint;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import atlantafx.base.theme.Dracula;

/**
 * The main class of the application.
 * @author Michał Hnatuśko.
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("BehindertPaint"), 640, 480);
        stage.setScene(scene);
        Application.setUserAgentStylesheet(new Dracula().getUserAgentStylesheet());
        // stage.setResizable(false);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("/paint_logo.png"))); // Fixed code
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}