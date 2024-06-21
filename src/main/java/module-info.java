module org.example.classactivity2yash {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens org.example.classactivity2yash to javafx.fxml;
    exports org.example.classactivity2yash;
}