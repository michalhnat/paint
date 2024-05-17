package com.paint;

// import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public interface MyShapeDrawer {
    public IShape handleMousePressed(MouseEvent event, MyColor color);
}
