package com.paint;

import java.io.Serializable;
import javafx.scene.shape.Circle;
/**
 * Represents a circle shape in the paint application.
 * Extends the Circle class and implements the IShape interface.
 * Provides methods to manipulate the circle's properties.
 */
public class MyCircle extends Circle implements IShape, Serializable{
    private MyPoint2D start_point;
    private MyPoint2D end_point;
    private double radius;
    private MyColor color;
    private boolean active = false;

    /**
     * Constructs a MyCircle object with the specified start point, end point, and color.
     * @param start_point The start point of the circle.
     * @param end_point The end point of the circle.
     * @param color The color of the circle.
     */
    public MyCircle (MyPoint2D start_point, MyPoint2D end_point, MyColor color){
        super(start_point.getX(), start_point.getY(), 0, color.to_color());
        this.start_point = start_point;
        this.end_point = end_point;
        this.color = color;

        MyCricleEventHandlers.activate_event_handlers(this);
    }

    /**
     * Returns the start point of the circle.
     * @return The start point of the circle.
     */
    public MyPoint2D get_start_point(){
        return this.start_point;
    }

    /**
     * Returns the end point of the circle.
     * @return The end point of the circle.
     */
    public MyPoint2D get_end_point(){
        return this.end_point;
    }

    /**
     * Returns the radius of the circle.
     * @return The radius of the circle.
     */
    public double get_radius(){
        return this.radius;
    }

    /**
     * Returns the color of the circle.
     * @return The color of the circle.
     */
    public MyColor get_color(){
        return this.color;
    }

    /**
     * Sets the color of the circle.
     * @param color The color to set.
     */
    public void set_color(MyColor color){
        this.color = color;
        super.setFill(color.to_color());
    }

    /**
     * Sets the start point of the circle.
     * @param start_point The start point to set.
     */
    public void set_start_point(MyPoint2D start_point){
        this.start_point = start_point;
        super.setCenterX(start_point.getX());
        super.setCenterY(start_point.getY());
    }

    /**
     * Checks if the circle is active.
     * @return true if the circle is active, false otherwise.
     */
    public boolean is_active(){
        return this.active;
    }

    /**
     * Sets the radius of the circle.
     * @param radius The radius to set.
     */
    public void set_radius(double radius){
        this.radius = radius;
        super.setRadius(radius);
    }

    /**
     * Sets the end point of the circle and calculates the radius.
     * @param end_point The end point to set.
     */
    public void set_end_point(MyPoint2D end_point) {

        this.radius = FigureUtils.calculate_radius(this.start_point, end_point); 
        super.setRadius(this.radius);
    }

    /**
     * Sets the active state of the circle.
     * @param focus The active state to set.
     */
    @Override
    public void set_active(boolean focus) {
        this.active = focus;
        if (!focus) {
            super.setStroke(null);
            super.setOpacity(1);
            super.getStrokeDashArray().clear();
        }
    }

    /**
     * Rebuilds the circle by updating its properties.
     */
    @Override
    public void rebuild(){
        super.setCenterX(this.start_point.getX());
        super.setCenterY(this.start_point.getY());
        super.setRadius(this.radius);
        super.setFill(this.color.to_color());
        MyCricleEventHandlers.activate_event_handlers(this);
        System.out.println(this);
    }
}
