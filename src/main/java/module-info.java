module it.calc.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires jdk.httpserver;

    opens com.example to javafx.fxml;
    exports com.example;
    exports com.example.arithmetics;
}