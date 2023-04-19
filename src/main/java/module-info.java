module com.example.finalprojext {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finalprojext to javafx.fxml;
    exports com.example.finalprojext;
}