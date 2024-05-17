package com.paint;

import javafx.scene.input.MouseEvent;

public class MyRectangleDrawer extends Drawer  implements MyShapeDrawer{

    public MyRectangleDrawer(){
    }

    @Override
    public IShape handleMousePressed(MouseEvent event, MyColor color){
        MyPoint2D start_point = new MyPoint2D(event.getX(), event.getY());
        MyRectangle mr = new MyRectangle(start_point, start_point, color);
        shape = mr;
        return mr;
    }
    
}
