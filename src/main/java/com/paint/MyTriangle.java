package com.paint;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.shape.Polygon;

public class MyTriangle extends Polygon implements IShape, Serializable{
    private MyPoint2D start_point;
    private MyPoint2D end_point;
    private MyColor color;
    private boolean active = false;
    private Transformations transformations = new Transformations();
    private MyPoint2D click_point;
    private ArrayList<Double> triangle_points = new ArrayList<Double>();

    public MyTriangle(MyPoint2D start_point, MyPoint2D end_point, MyColor color){
        super();

        MyTriangleEventHandlers.activate_event_handlers(this);

        super.setFill(color.to_color());
        this.start_point = start_point;
        this.end_point = end_point;
        this.color = color;
    }

    @Override
    public void rebuild(){
        super.getPoints().clear();
        update_points_dx_dy();
        super.getPoints().addAll(this.triangle_points);
        super.setScaleX(transformations.get_scale_x());
        super.setScaleY(transformations.get_scale_y());
        super.setRotate(transformations.get_rotate());
        super.setFill(color.to_color());
        MyTriangleEventHandlers.activate_event_handlers(this);
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

    public void update_local_points(){
        this.triangle_points = new ArrayList<Double>();
        for (Double point : super.getPoints()) {
            this.triangle_points.add(point);
        }
    }

    public void update_points_dx_dy(){
        double sum_dx = transformations.get_sum_dx();
        double sum_dy = transformations.get_sum_dy();
        System.out.println(this.triangle_points);
        for (int i = 0; i < triangle_points.size(); i += 2) {
            triangle_points.set(i,triangle_points.get(i) + sum_dx);
            triangle_points.set(i + 1, triangle_points.get(i + 1) + sum_dy);
        }
        super.getPoints().clear();

        transformations.set_sum_dx(0);
        transformations.set_sum_dy(0);
    }

    public void set_end_point(MyPoint2D end_point){
        this.end_point = end_point;

        double halfBaseLength = FigureUtils.calculate_x_distance(start_point, end_point);
        double height = (start_point.getY() - end_point.getY());

        super.getPoints().clear();

        super.getPoints().addAll(new Double[]{
            start_point.getX() - halfBaseLength, start_point.getY(),
            start_point.getX() + halfBaseLength, start_point.getY(),
            start_point.getX(), start_point.getY() - height
        });

        update_local_points();

    }

    public Transformations get_transformations(){
        return this.transformations;
    }

    public MyPoint2D get_click_point(){
        return this.click_point;
    }

    public void set_click_point(MyPoint2D click_point){
        this.click_point = click_point;
    }

    public MyPoint2D get_start_point(){
        return this.start_point;
    }

    public MyPoint2D get_end_point(){
        return this.end_point;
    }

    public MyColor get_color(){
        return this.color;
    }

    public void set_color(MyColor color){
        this.color = color;
        super.setFill(color.to_color());
    }

    public void set_start_point(MyPoint2D start_point){
        this.start_point = start_point;
    }
    
    public boolean is_active() {
        return active;
    }

}
