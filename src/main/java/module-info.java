module com.example.gridpaneform {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gridpaneform to javafx.fxml;
    opens com.example.gridpaneform.controllers;
    opens com.example.gridpaneform.models;
    exports com.example.gridpaneform;
}