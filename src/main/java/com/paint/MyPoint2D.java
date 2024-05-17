package com.paint;
import java.io.Serializable;

// import javafx.geometry.Point2D;

public class MyPoint2D implements Serializable {
    private double x;
    private double y;

    public MyPoint2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
