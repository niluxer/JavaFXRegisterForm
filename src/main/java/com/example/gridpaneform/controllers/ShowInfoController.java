package com.example.gridpaneform.controllers;

import com.example.gridpaneform.models.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShowInfoController implements Initializable {

    private List<Person> personList;
    private ObservableList<Person> personObservableList;
    @FXML
    TableView<Person> tblPerson;

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        personObservableList = FXCollections.observableArrayList(personList);
        tblPerson.setItems(personObservableList);
    }
}
