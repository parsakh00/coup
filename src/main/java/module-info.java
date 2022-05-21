module example.coup {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires com.google.gson;
    requires json.simple;

    opens example.coup to javafx.fxml;
    exports example.coup;
    exports example.coup.model;
    exports example.coup.gui;
    opens example.coup.gui to javafx.fxml;
    exports example.coup.game;
    opens example.coup.game to javafx.fxml;
}