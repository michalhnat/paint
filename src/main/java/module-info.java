module com.paint {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires javafx.graphics;
    requires atlantafx.base;

    opens com.paint to javafx.fxml;
    exports com.paint;
}
