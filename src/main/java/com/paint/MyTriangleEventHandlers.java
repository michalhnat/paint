package com.paint;

public class MyTriangleEventHandlers {
    public static void activate_event_handlers(MyTriangle mt) {
        ActiveManager.active_shape_event(mt);

        mt.setOnMousePressed(event -> {
            if (mt.is_active()) {
                mt.set_click_point(new MyPoint2D(event.getSceneX(), event.getSceneY()));
            }
        });

        mt.setOnMouseDragged(event -> {
            if (mt.is_active()) {
                if (mt.get_click_point() == null) {
                    mt.set_click_point(new MyPoint2D(event.getX(), event.getY()));
                }
                double dx = event.getSceneX() - mt.get_click_point().getX();
                double dy = event.getSceneY() - mt.get_click_point().getY();

                mt.setLayoutX(mt.getLayoutX() + dx);
                mt.setLayoutY(mt.getLayoutY() + dy);

                mt.get_transformations().update_dx_dy(dx, dy);

                mt.set_click_point(new MyPoint2D(event.getSceneX(), event.getSceneY()));
                
            }
        });

        mt.setOnScroll(event -> {

            Transformations t = mt.get_transformations();
            if (mt.is_active() && !event.isControlDown()) {
                double scale_factor = 1 + (event.getDeltaY() * 0.002);

                mt.setScaleX(mt.getScaleX() * scale_factor);
                mt.setScaleY(mt.getScaleY() * scale_factor);

                t.set_scale_x(scale_factor * t.get_scale_x());
                t.set_scale_y(scale_factor * t.get_scale_y());

            }

            if (mt.is_active() && event.isControlDown()) {
                double delta_y = event.getDeltaY();

                mt.setRotate(delta_y > 0 ? mt.getRotate() + 10 : mt.getRotate() - 10);    
                t.set_rotate(delta_y > 0 ? t.get_rotate() + 10 : t.get_rotate() - 10);
            }

        });
    }
}
