package com.paint;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * The DrawingPane class represents a custom JavaFX pane used for drawing shapes.
 * It extends the Pane class and provides methods for adding shapes, setting the current drawer and color,
 * serializing and deserializing the current state.
 */
public class DrawingPane extends Pane{
    
    private ArrayList<IShape> shapes = new ArrayList<IShape>();
    private Drawer current_drawer;
    private MyColor current_color;

    /**
     * Constructs a new DrawingPane object.
     * Sets up the clip for the pane and registers event handlers for mouse interactions. That way shapes don't get drawn outside the pane.
     */
    public DrawingPane(){
        super();

        Rectangle clip = new Rectangle();
        clip.widthProperty().bind(this.widthProperty());
        clip.heightProperty().bind(this.heightProperty());

        this.setClip(clip);

        setOnMousePressed(event -> {
            if (current_drawer == null) {
                return;
            }
            add_shape(current_drawer.handleMousePressed(event, current_color));
        });

        setOnMouseDragged(event -> {
            if (current_drawer == null) {
                return;
            }
            current_drawer.handleMouseDragged(event);
        });

        setOnMouseReleased(event -> {
            if (current_drawer == null) {
                return;
            }
            current_drawer.handleMouseReleased(event);
        });
    }

    /**
     * Adds a shape to the drawing pane.
     * The shape is added to the beginning of the shapes list and displayed on the pane.
     * 
     * @param shape The shape to be added.
     */
    public void add_shape(IShape shape){
        this.shapes.add(0, shape);
        super.getChildren().add((Shape) shape);
    }

    /**
     * Returns the list of shapes currently on the drawing pane.
     * 
     * @return The list of shapes.
     */
    public ArrayList<IShape> get_shapes() {
        return shapes;
    }

    /**
     * Sets the current drawer for drawing shapes.
     * 
     * @param drawer The drawer to be set as the current drawer.
     */
    public void set_current_drawer(Drawer drawer){
        this.current_drawer = drawer;
    }

    /**
     * Sets the current color for drawing shapes.
     * 
     * @param color The color to be set as the current color.
     */
    public void set_current_color(MyColor color){
        this.current_color = color;
    }

    /**
     * Serializes the current state of the drawing pane and saves it to a file.
     * 
     * @param file_name The name of the file to save the serialized state.
     */
    public void serialize_current_state(String file_name){
        Serializer.serializeArray(shapes, file_name);
    }

    /**
     * Deserializes a previously serialized state of the drawing pane from a file.
     * The deserialized shapes are added to the drawing pane and displayed.
     * 
     * @param file_name The name of the file to deserialize the state from.
     */
    public void deserialize_current_state(String file_name){
        this.shapes = Serializer.deserializeArray(file_name);
        super.getChildren().clear();
        for (IShape shape : shapes){
            
            shape.rebuild();
            System.out.println(shape);
            super.getChildren().add(0, (Shape) shape);
        }
    }
}
