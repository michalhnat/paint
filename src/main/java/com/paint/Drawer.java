package com.paint;

import javafx.geometry.Point2D;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * @brief The abstract class representing a drawer for drawing shapes on a canvas.
 */
public abstract class Drawer {
    protected MyPoint2D start_point;
    protected MyPoint2D end_point;
    protected IShape shape;

    /**
     * @brief Constructs a new instance of the Drawer class.
     */
    public Drawer() {

    }

    /**
     * @brief Handles the mouse pressed event and returns the shape to be drawn.
     *
     * @param event the MouseEvent representing the mouse pressed event
     * @param color the color of the shape to be drawn
     * @return the shape to be drawn
     */
    public abstract IShape handleMousePressed(MouseEvent event, MyColor color);

    /**
     * @brief Handles the mouse dragged event and updates the end point of the shape being drawn.
     *
     * @param event the MouseEvent representing the mouse dragged event
     */
    public void handleMouseDragged(MouseEvent event) {
        shape.set_end_point(new MyPoint2D(event.getX(), event.getY()));
    }

    /**
     * @brief Handles the mouse released event and updates the end point of the shape being drawn.
     *
     * @param event the MouseEvent representing the mouse released event
     */
    public void handleMouseReleased(MouseEvent event) {
        shape.set_end_point(new MyPoint2D(event.getX(), event.getY()));
    }
}
