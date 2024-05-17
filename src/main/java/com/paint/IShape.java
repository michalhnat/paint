package com.paint;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

/**
 * The IShape interface represents a shape in a painting application.
 * It provides methods to get and set the start and end points of the shape,
 * get and set the color of the shape, set the active state of the shape,
 * rebuild the shape, and check if the shape is active.
 */
public interface IShape {

    /**
     * Gets the start point of the shape.
     *
     * @return the start point of the shape
     */
    MyPoint2D get_start_point();

    /**
     * Gets the end point of the shape.
     *
     * @return the end point of the shape
     */
    MyPoint2D get_end_point();

    /**
     * Sets the start point of the shape.
     *
     * @param start_point the start point to set
     */
    void set_start_point(MyPoint2D start_point);

    /**
     * Sets the end point of the shape.
     *
     * @param end_point the end point to set
     */
    void set_end_point(MyPoint2D end_point);

    /**
     * Gets the color of the shape.
     *
     * @return the color of the shape
     */
    MyColor get_color();

    /**
     * Sets the color of the shape.
     *
     * @param color the color to set
     */
    void set_color(MyColor color);

    /**
     * Sets the active state of the shape.
     *
     * @param focus true if the shape is active, false otherwise
     */
    void set_active(boolean focus);

    /**
     * Rebuilds the shape.
     */
    void rebuild();

    /**
     * Checks if the shape is active.
     *
     * @return true if the shape is active, false otherwise
     */
    boolean is_active();

}
