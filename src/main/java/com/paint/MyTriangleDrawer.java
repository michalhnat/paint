package com.paint;

import javafx.scene.input.MouseEvent;

public class MyTriangleDrawer extends Drawer implements MyShapeDrawer{
    public MyTriangleDrawer(){

    }
    
    @Override
    public IShape handleMousePressed(MouseEvent event, MyColor color){
        MyPoint2D start_point = new MyPoint2D(event.getX(), event.getY());
        MyTriangle mt = new MyTriangle(start_point, start_point, color);
        shape = mt;
        return mt;
    }
}
