package com.paint;

import java.io.Serializable;
import javafx.scene.paint.Color;

import javafx.scene.paint.Color;
import java.io.Serializable;

/**
 * Represents a custom color with red, green, blue, and opacity values.
 * Needed to serialize the JavaFX Color object, which is not serializable by default.
 */
public class MyColor implements Serializable {
    private double red;
    private double green;
    private double blue;
    private double opacity;

    /**
     * Constructs a MyColor object from a JavaFX Color object.
     *
     * @param color the JavaFX Color object to convert
     */
    public MyColor(Color color) {
        this.red = color.getRed();
        this.green = color.getGreen();
        this.blue = color.getBlue();
        this.opacity = color.getOpacity();
    }

    /**
     * Converts the MyColor object to a JavaFX Color object.
     *
     * @return the JavaFX Color object representing this MyColor
     */
    public Color to_color() {
        return new Color(red, green, blue, opacity);
    }
}