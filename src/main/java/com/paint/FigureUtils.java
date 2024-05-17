package com.paint;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;


/**
 * The FigureUtils class provides utility methods for calculating various properties of figures.
 * @brief Provides utility methods for calculating various properties of figures.
 */
public class FigureUtils {

    /**
     * @brief Calculates the distance between two points.
     *
     * @param start_point the starting point
     * @param end_point the ending point
     * @return the radius between the two points simple euclidean distance
     */
    public static double calculate_radius(MyPoint2D start_point, MyPoint2D end_point){
        double radius = Math.sqrt(Math.pow((end_point.getX() - start_point.getX()), 2) + Math.pow((end_point.getY() - start_point.getY()), 2));
        return radius;
    }

    /**
     * @brief Calculates the horizontal distance between two points.
     *
     * @param start_point the starting point
     * @param end_point the ending point
     * @return the horizontal distance between the two points
     */
    public static double calculate_x_distance(MyPoint2D start_point, MyPoint2D end_point){
        double width = Math.abs(end_point.getX() - start_point.getX());
        return width;
    }

    /**
     * @brief Calculates the vertical distance between two points.
     *
     * @param start_point the starting point
     * @param end_point the ending point
     * @return the vertical distance between the two points
     */
    public static double calculate_y_distance(MyPoint2D start_point, MyPoint2D end_point){
        double height = Math.abs(end_point.getY() - start_point.getY());
        return height;
    }

    /**
     * @brief Calculates the top-left point of a rectangle defined by two points.
     *
     * @param start_point the starting point
     * @param end_point the ending point
     * @return the top-left point of the rectangle
     */
    public static MyPoint2D calculate_top_left_point(MyPoint2D start_point, MyPoint2D end_point){
        double x = Math.min(start_point.getX(), end_point.getX());
        double y = Math.min(start_point.getY(), end_point.getY());
        return new MyPoint2D(x, y);
    }

    /**
     * @brief Calculates the bottom-right point of a rectangle defined by two points.
     *
     * @param start_point the starting point
     * @param end_point the ending point
     * @return the bottom-right point of the rectangle
     */
    public static MyPoint2D calulate_bootom_right_point(MyPoint2D start_point, MyPoint2D end_point){
        double x = Math.max(start_point.getX(), end_point.getX());
        double y = Math.max(start_point.getY(), end_point.getY());
        return new MyPoint2D(x, y);
    }

    /**
     * @brief Calculates the center point of a polygon.
     *
     * @param polygon the polygon
     * @return the center point of the polygon
     */
    public static MyPoint2D calculate_polygon_center(Polygon polygon){
        double x = 0;
        double y = 0;
        for(int i = 0; i < polygon.getPoints().size(); i+=2){
            x += polygon.getPoints().get(i);
            y += polygon.getPoints().get(i+1);
        }
        x /= polygon.getPoints().size()/2;
        y /= polygon.getPoints().size()/2;
        return new MyPoint2D(x, y);
    }

}






/*    USED FOR LIMITERS TO WORK
 *     public static double calculate_distance_to_closest_border(MyPoint2D start_point, DrawingPane drawing_area) {
        double distanceToLeft = start_point.getX();
        double distanceToRight = drawing_area.getWidth() - start_point.getX();
        double distanceToTop = start_point.getY();
        double distanceToBottom = drawing_area.getHeight() - start_point.getY();
    
        return Math.min(Math.min(distanceToLeft, distanceToRight), Math.min(distanceToTop, distanceToBottom));
    }

    public static double calculate_distance_to_closest_vertical_border(MyPoint2D start_point, DrawingPane drawing_area){
        double distanceToLeft = start_point.getX();
        double distanceToRight = drawing_area.getWidth() - start_point.getX();

        return Math.min(distanceToLeft, distanceToRight);
    }

    public static double calculate_distance_to_top_border(MyPoint2D start_point) {
        return start_point.getY();
    }

    public static double calculate_distance_to_bottom_border(MyPoint2D start_point, DrawingPane drawing_area) {
        return drawing_area.getHeight() - start_point.getY();
    }
 */