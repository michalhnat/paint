package com.paint;

import java.io.Serializable;

import java.io.Serializable;

/**
 * The Transformations class represents the transformations applied to an object.
 * It includes rotation, translation, and scaling.
 */
public class Transformations implements Serializable {
    private double rotate = 0;
    private double sum_dx = 0;
    private double sum_dy = 0;
    private double scale_x = 1;
    private double scale_y = 1;

    /**
     * Constructs a new Transformations object with default values.
     */
    public Transformations() {
    }

    /**
     * Updates the translation values by adding the given dx and dy values.
     *
     * @param dx The amount to translate in the x-axis.
     * @param dy The amount to translate in the y-axis.
     */
    public void update_dx_dy(double dx, double dy) {
        this.sum_dx += dx;
        this.sum_dy += dy;
    }

    /**
     * Returns the scaling factor in the x-axis.
     *
     * @return The scaling factor in the x-axis.
     */
    public double get_scale_x() {
        return this.scale_x;
    }

    /**
     * Sets the scaling factor in the x-axis.
     *
     * @param scale_x The scaling factor in the x-axis.
     */
    public void set_scale_x(double scale_x) {
        this.scale_x = scale_x;
    }

    /**
     * Returns the scaling factor in the y-axis.
     *
     * @return The scaling factor in the y-axis.
     */
    public double get_scale_y() {
        return this.scale_y;
    }

    /**
     * Sets the scaling factor in the y-axis.
     *
     * @param scale_y The scaling factor in the y-axis.
     */
    public void set_scale_y(double scale_y) {
        this.scale_y = scale_y;
    }

    /**
     * Returns the total translation in the x-axis.
     *
     * @return The total translation in the x-axis.
     */
    public double get_sum_dx() {
        return this.sum_dx;
    }

    /**
     * Sets the total translation in the x-axis.
     *
     * @param sum_dx The total translation in the x-axis.
     */
    public void set_sum_dx(double sum_dx) {
        this.sum_dx = sum_dx;
    }

    /**
     * Returns the total translation in the y-axis.
     *
     * @return The total translation in the y-axis.
     */
    public double get_sum_dy() {
        return this.sum_dy;
    }

    /**
     * Sets the total translation in the y-axis.
     *
     * @param sum_dy The total translation in the y-axis.
     */
    public void set_sum_dy(double sum_dy) {
        this.sum_dy = sum_dy;
    }

    /**
     * Returns the rotation angle in degrees.
     *
     * @return The rotation angle in degrees.
     */
    public double get_rotate() {
        return this.rotate;
    }

    /**
     * Sets the rotation angle in degrees.
     *
     * @param rotate The rotation angle in degrees.
     */
    public void set_rotate(double rotate) {
        this.rotate = rotate;
    }
}
