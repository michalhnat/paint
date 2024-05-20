package com.paint;

import java.io.Serializable;
import javafx.scene.shape.Rectangle;
/**
 * Represents a rectangle shape in a painting application.
 * Extends the Rectangle class and implements the IShape and Serializable interfaces.
 */
public class MyRectangle extends Rectangle implements IShape, Serializable{
    private MyPoint2D start_point;
    private MyPoint2D end_point;
    private MyPoint2D top_left_point;
    private double width;
    private double height;
    private Transformations transformations = new Transformations();
    private MyPoint2D click_point;
    private MyColor color;
    private boolean active = false;


    /**
     * Constructs a rectangle with the specified start point, end point, and color.
     * Activates the event handlers for the rectangle.
     * @param start_point the start point of the rectangle - in javafx coordinates top left corner of the rectangle
     * @param end_point the end point of the rectangle - in javafx coordinates bottom right corner of the rectangle
     * @param color the color of the rectangle
     */
    public MyRectangle (MyPoint2D start_point, MyPoint2D end_point, MyColor color){
        super();

        MyRectangleEventHandlers.activate_event_handlers(this);

        super.setFill(color.to_color());
        this.start_point = start_point;
        this.end_point = end_point;
        this.color = color;
        this.width = 0;
        this.height = 0;
        super.setFill(color.to_color());
    }

    /**
     * Rebuilds the rectangle based on the current transformations and properties.
     * This method updates the position, size, fill color, scale, and rotation of the rectangle.
     * It also activates the event handlers for the rectangle.
     */
    @Override
    public void rebuild() {
        super.setX(start_point.getX() + transformations.get_sum_dx());
        super.setY(start_point.getY() + transformations.get_sum_dy());
        super.setWidth(width);
        super.setHeight(height);
        super.setFill(color.to_color());
        super.setScaleX(transformations.get_scale_x());
        super.setScaleY(transformations.get_scale_y());
        super.setRotate(transformations.get_rotate());

        MyRectangleEventHandlers.activate_event_handlers(this);
    } 

    @Override
    public void set_active(boolean focus) {
        this.active = focus;
        if (!focus) {
            super.setStroke(null);
            super.setOpacity(1);
            super.getStrokeDashArray().clear();
        }
    }

    public void set_end_point(MyPoint2D end_point){
        this.end_point = end_point;

        set_width(FigureUtils.calculate_x_distance(start_point, this.end_point));
        set_height(FigureUtils.calculate_y_distance(start_point, this.end_point));

        this.top_left_point = FigureUtils.calculate_top_left_point(start_point, this.end_point);
        super.setX(top_left_point.getX());
        super.setY(top_left_point.getY());

    }

    public Transformations get_transformations(){
        return this.transformations;
    }

    public MyPoint2D get_start_point(){
        return this.start_point;
    }

    public MyPoint2D get_end_point(){
        return this.end_point;
    }

    public double get_width(){
        return this.width;
    }

    public double get_height(){
        return this.height;
    }

    public MyPoint2D get_click_point(){
        return this.click_point;
    }

    public void set_click_point(MyPoint2D click_point){
        this.click_point = click_point;
    }

    public void set_width(double width){
        this.width = width;
        super.setWidth(width);
    }

    public void set_height(double height){
        this.height = height;
        super.setHeight(height);
    }

    public void set_start_point(MyPoint2D start_point){
        super.setX(start_point.getX());
        super.setY(start_point.getY());
        this.start_point = start_point;
    }

    public boolean is_active(){
        return this.active;
    }

    public MyColor get_color(){
        return this.color;
    }

    public void set_color(MyColor color){
        this.color = color;
        super.setFill(color.to_color());
    }

}
