module com.example.megagraph {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.megagraph to javafx.fxml;
    exports com.example.megagraph;
}