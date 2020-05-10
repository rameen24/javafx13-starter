module com.sample {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sample.controllers to javafx.fxml;
    exports com.sample;

    exports com.sample.ProduktData;
    opens com.sample.ProduktData to javafx.base;
}