package com.paint;

import java.io.File;
import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class PaintController {
    
    @FXML
    private DrawingPane drawing_area;

    @FXML
    private Button rectangle_button;

    @FXML
    private Button circle_button;

    @FXML
    private Button triangle_button;

    @FXML
    private ColorPicker color_picker;

    @FXML
    private Button select_button;

    @FXML
    private MenuItem save_button;

    @FXML
    private MenuItem save_as_button;

    @FXML MenuItem open_button;

    @FXML
    private MenuItem about_button;

    private File selected_file;

    private Drawer current_drawer;

    private HashMap<String, Drawer> figureMap = new HashMap<>();


    /**
     * Initializes the PaintController.
     * This method is called when the associated FXML file is loaded.
     * It sets the initial color of the drawing area based on the value of the color picker.
     * It also adds a listener to the color picker to update the color of the active shape and the drawing area
     * whenever the selected color changes.
     * It initializes the figureMap with the corresponding button IDs and their respective shape drawers.
     */
    @FXML
    public void initialize() {
        drawing_area.set_current_color(new MyColor(color_picker.getValue()));

        color_picker.valueProperty().addListener((observable, oldColor, newColor) -> {
            IShape activeShape = ActiveManager.get_active_shape();
            if (activeShape != null) {
                activeShape.set_color(new MyColor(newColor));
            }
            drawing_area.set_current_color(new MyColor(newColor));
        });
        
        this.current_drawer = null;

        figureMap.put("Button[id=rectangle_button, styleClass=button]'Rectangle'", new MyRectangleDrawer());
        figureMap.put("Button[id=circle_button, styleClass=button]'Circle'", new MyCircleDrawer());
        figureMap.put("Button[id=triangle_button, styleClass=button]'Triangle'", new MyTriangleDrawer());
        figureMap.put("Button[id=select_button, styleClass=button]'Select'", null);
    }


    /**
     * Handles the selection of a drawing mode.
     * 
     * @param event The action event triggered by the selection.
     */
    @FXML
    private void select_mode(ActionEvent event) {
        current_drawer = figureMap.get(event.getSource().toString());

        drawing_area.set_current_drawer(current_drawer);
        ActiveManager.set_active_shape_null();
        ActiveManager.set_drawer_active(current_drawer != null);
    }

    /**
     * Saves the current state of the drawing area.
     * If a file is already selected, the current state is serialized and saved to that file.
     * If no file is selected, the 'save_as' method is called to prompt the user to choose a file.
     *
     * @param event The action event that triggered the save operation.
     */
    @FXML
    private void save(ActionEvent event) {
        ActiveManager.set_active_shape_null();
        if (selected_file != null) {
            drawing_area.serialize_current_state(selected_file.getAbsolutePath());
        }
        else{
            save_as(event);
        }
    }

    /**
     * Saves the current state of the drawing area as a Paint file.
     * Prompts the user to choose a file location and saves the file with the extension ".kindor".
     * If the user cancels the file selection, an error popup is displayed.
     *
     * @param event The action event that triggered the save_as method.
     */
    @FXML
    private void save_as(ActionEvent event) {
        ActiveManager.set_active_shape_null();
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save as");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Paint Files", "*.kindor"));
        File selected_file = chooser.showSaveDialog(drawing_area.getScene().getWindow());
        if (selected_file != null) {
            drawing_area.serialize_current_state(selected_file.getAbsolutePath());
            this.selected_file = selected_file;
        }else{
            MyErrorPopup error_popup = new MyErrorPopup("There was problem saving a file");
            Stage stage = (Stage) drawing_area.getScene().getWindow();;
            error_popup.show(stage);
        }
    }

    /**
     * Opens a file dialog to select a Paint file and deserializes its contents.
     * If a file is selected, the current state of the drawing area is updated with the contents of the selected file.
     * If no file is selected, an error popup is displayed.
     *
     * @param event the action event that triggered the method
     */
    @FXML
    private void open(ActionEvent event) {
        ActiveManager.set_active_shape_null();
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Paint Files", "*.kindor"));
        File selected_file = chooser.showOpenDialog(drawing_area.getScene().getWindow());
        if (selected_file != null) {
            drawing_area.deserialize_current_state(selected_file.getAbsolutePath());
            this.selected_file = selected_file;
            System.out.println("Opened file: " + selected_file.getAbsolutePath());
        }
        else{
            MyErrorPopup error_popup = new MyErrorPopup("There was problem opening a file");
            Stage stage = (Stage) drawing_area.getScene().getWindow();;
            error_popup.show(stage);
        }
    }

    /**
     * Displays the "About" popup window.
     * Sets the active shape to null and creates a new instance of MyPopup to show the about information.
     * The about information includes the Paint version and the creator's name.
     */
    @FXML
    private void about() {
        ActiveManager.set_active_shape_null();
        MyPopup about_popup = new MyPopup("Paint version: gowno Created by Michal Hnatusko", "About");
        Stage stage = (Stage) drawing_area.getScene().getWindow();;
        about_popup.show(stage);
    }

}
