package com.paint;

import javafx.scene.paint.Color;

/**
 * The Utils class provides utility methods for color manipulation.
 */
public class Utils {
    /**
     * Inverts the given color.
     *
     * @param color the color to invert
     * @return the inverted color
     */
    public static Color invert(Color color) {
        return Color.color(1 - color.getRed(), 1 - color.getGreen(), 1 - color.getBlue(), color.getOpacity());
    }
}
