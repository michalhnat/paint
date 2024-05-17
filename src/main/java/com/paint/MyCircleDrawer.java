package com.paint;

import javafx.scene.input.MouseEvent;

/**
 * This class represents a drawer for drawing circles on a canvas.
 * It extends the `Drawer` class and implements the `MyShapeDrawer` interface.
 */
public class MyCircleDrawer extends Drawer implements MyShapeDrawer{

    /**
     * Constructs a new instance of the `MyCircleDrawer` class.
     */
    public MyCircleDrawer(){
    
    }
    
    /**
     * Handles the mouse pressed event and returns the created circle shape.
     * 
     * @param event The mouse event containing the coordinates of the mouse press.
     * @param color The color of the circle.
     * @return The created circle shape.
     */
    @Override
    public IShape handleMousePressed(MouseEvent event, MyColor color){
        MyPoint2D start_point = new MyPoint2D(event.getX(), event.getY());
        MyCircle mc = new MyCircle(start_point, start_point, color);
        shape = mc;
        return mc;
    }
}
