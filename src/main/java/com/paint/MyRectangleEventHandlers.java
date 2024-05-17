package com.paint;

/**
 * This class contains event handlers for MyRectangle objects.
 */
public class MyRectangleEventHandlers {
    /**
     * Activates the event handlers for the given MyRectangle object.
     * 
     * @param mr The MyRectangle object to activate the event handlers for.
     */
    public static void activate_event_handlers(MyRectangle mr) {
        // Activate the shape event for the MyRectangle object
        ActiveManager.active_shape_event(mr);
        
        // Set the mouse pressed event handler
        mr.setOnMousePressed(event -> {
            if (mr.is_active()) {
                mr.set_click_point(new MyPoint2D(event.getSceneX(), event.getSceneY()));
            }
        });

        // Set the mouse dragged event handler
        mr.setOnMouseDragged(event -> {
            if (mr.is_active()) {
                if (mr.get_click_point() == null) {
                    mr.set_click_point(new MyPoint2D(event.getX(), event.getY()));
                }
                double dx = event.getSceneX() - mr.get_click_point().getX();
                double dy = event.getSceneY() - mr.get_click_point().getY();
    
                mr.setLayoutX(mr.getLayoutX() + dx);
                mr.setLayoutY(mr.getLayoutY() + dy);

                mr.get_transformations().update_dx_dy(dx, dy);
                
                mr.set_click_point(new MyPoint2D(event.getSceneX(), event.getSceneY()));
            }
        });

        // Set the scroll event handler
        mr.setOnScroll(event -> {
            Transformations t = mr.get_transformations();

            if (mr.is_active() && !event.isControlDown()) {
                double scale_factor = 1 + (event.getDeltaY() * 0.002);

                mr.setScaleX(mr.getScaleX() * scale_factor);
                mr.setScaleY(mr.getScaleY() * scale_factor);

                t.set_scale_x(scale_factor * t.get_scale_x());
                t.set_scale_y(scale_factor * t.get_scale_y());
            }

            if (mr.is_active() && event.isControlDown()) {
                double delta_y = event.getDeltaY();
                mr.setRotate(delta_y > 0 ? mr.getRotate() + 10 : mr.getRotate() - 10);
                t.set_rotate(delta_y > 0 ? t.get_rotate() + 10 : t.get_rotate() - 10);
            }
        });
    }
}


