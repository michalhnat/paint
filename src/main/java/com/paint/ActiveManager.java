package com.paint;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;

/**
 * The ActiveManager class is responsible for managing the active shape and drawer state in the Paint application.
 */
public class ActiveManager {
    private static IShape active_shape = null;
    private static boolean is_drawer_active = false;

    /**
     * Sets the active shape event handler for a given shape.
     * 
     * @param shape The shape to set the active shape event handler for.
     */
    public static void active_shape_event(Shape shape) {
        shape.setOnMouseClicked(event -> {
            if (is_drawer_active) {
                return;
            }

            if (active_shape != null) {
                active_shape.set_active(false);
            }

            active_shape = (IShape) shape;
            active_shape.set_active(true);
            
            Color invertedColor = Utils.invert((Color) shape.getFill());

            shape.setOpacity(0.7);
            shape.setStroke(invertedColor);
            shape.setStrokeType(StrokeType.OUTSIDE);
            shape.setStrokeWidth(3);
            shape.getStrokeDashArray().setAll(10.0, 10.0);
            shape.requestFocus();
        });
    }

    /**
     * Sets the active shape to null and deactivates it.
     */
    public static void set_active_shape_null() {
        if (active_shape != null)
            active_shape.set_active(false);
            active_shape = null;
    }

    /**
     * Sets the drawer active state.
     * 
     * @param active The active state of the drawer.
     */
    public static void set_drawer_active(boolean active) {
        is_drawer_active = active;
    }

    /**
     * Checks if the drawer is active.
     * 
     * @return true if the drawer is active, false otherwise.
     */
    public static boolean is_drawer_active() {
        return is_drawer_active;
    }

    /**
     * Checks if there is an active shape.
     * 
     * @return true if there is an active shape, false otherwise.
     */
    public static boolean is_active_shape() {
        return active_shape != null;
    }

    /**
     * Gets the active shape.
     * 
     * @return The active shape.
     */
    public static IShape get_active_shape() {
        return active_shape;
    }
}
