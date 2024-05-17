package com.paint;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * A custom popup window that displays a message and title.
 */
public class MyPopup extends Stage {
    /**
     * Constructs a new MyPopup with the specified message and title.
     *
     * @param message the message to be displayed in the popup
     * @param title   the title of the popup window
     */
    public MyPopup(String message, String title) {
        super();

        Image image = new Image(getClass().getResourceAsStream("/paint_logo.png"));
        ImageView imageView = new ImageView(image);

        super.setTitle(title);

        VBox vbox = new VBox();

        vbox.getChildren().add(imageView);
        vbox.getChildren().add(new Label(message));

        vbox.setAlignment(javafx.geometry.Pos.CENTER);

        super.setScene(new Scene(vbox));
    }

    /**
     * Shows the popup window and sets the owner and modality.
     *
     * @param owner the owner stage of the popup window
     */
    public void show(Stage owner) {
        this.initOwner(owner);
        this.initModality(Modality.APPLICATION_MODAL);

        super.show();
    }
}
