module com.sample {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.sample.controllers to javafx.fxml;
    exports com.sample;

    exports com.sample.ProduktData;
    opens com.sample.ProduktData to javafx.base;

    exports com.sample.controllers.Controller_Admin;
    opens com.sample.controllers.Controller_Admin to javafx.fxml;

    exports com.sample.controllers.Controller_Bruker;
    opens com.sample.controllers.Controller_Bruker to javafx.fxml;


}