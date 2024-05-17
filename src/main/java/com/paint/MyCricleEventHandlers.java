package com.paint;

public class MyCricleEventHandlers {
    public static void activate_event_handlers(MyCircle mc) {
        ActiveManager.active_shape_event(mc);
        
        mc.setOnMouseDragged(event -> {
            if (mc.is_active()) {
                mc.set_start_point(new MyPoint2D(event.getX(), event.getY()));
            }
        });

        mc.setOnScroll(event -> {
            if (mc.is_active()) {
                double scale_factor = 1 + event.getDeltaY() * 0.002;
                mc.set_radius(scale_factor * mc.get_radius());
            }
        });
    }
}
