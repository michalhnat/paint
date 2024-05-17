package com.paint;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Represents a custom error popup window.
 */
public class MyErrorPopup extends Stage {

    /**
     * Constructs a new MyErrorPopup object with the specified error message.
     *
     * @param message the error message to be displayed in the popup
     */
    public MyErrorPopup(String message) {
        super();

        super.setTitle("Error");

        VBox vbox = new VBox();

        vbox.getChildren().add(new Label(message));
        vbox.setAlignment(javafx.geometry.Pos.CENTER);

        super.setScene(new Scene(vbox));
    }

    /**
     * Shows the error popup window and sets the owner stage.
     *
     * @param owner the owner stage of the popup window
     */
    public void show(Stage owner) {
        this.initOwner(owner);
        this.initModality(Modality.APPLICATION_MODAL);

        super.show();
    }
}
