package com.example.gridpaneform;

import com.example.gridpaneform.controllers.ShowInfoController;
import com.example.gridpaneform.models.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HelloController {
    @FXML
    private TextField firstName, lastName, email, company, areaCode, phoneNumber;
    @FXML
    private ComboBox<String> gender;
    @FXML
    private DatePicker birthDate;

    private List<Person> personList = new ArrayList<>();

    @FXML
    protected void onCancelClick() {

    }
    @FXML
    protected void onRegisterClick() {
        Person person = new Person();
        Random random = new Random();
        person.setId(random.nextInt(1000));
        person.setFirstName(firstName.getText());
        person.setLastName(lastName.getText());
        person.setCompany(company.getText());
        person.setEmail(email.getText());
        person.setAreaCode(areaCode.getText());
        person.setPhoneNumber(phoneNumber.getText());
        person.setGender(gender.getValue());
        person.setBirthDate(birthDate.getValue().toString());
        personList.add(person);
        showMessage("Register has been successfully.");
    }

    @FXML
    protected void onShowInfoClick()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("person_info.fxml"));
        ShowInfoController infoController = new ShowInfoController();
        infoController.setPersonList(personList);

        loader.setController(infoController);

        Parent root = null;

        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Stage infoStage = new Stage();
        Scene scene = new Scene(root, 600, 400);
        infoStage.setScene(scene);
        infoStage.show();

        /*
        String message = "";
        for(Person p: personList)
        {
            message += "ID: " + p.getId() + "\n";
            message += "First Name: " + p.getFirstName() + "\n";
            message += "Last Name: " + p.getLastName() + "\n";
            message += "E-Mail: " + p.getEmail() + "\n";
            message += "Area Code: " + p.getAreaCode() + "\n";
            message += "Phone Number: " + p.getPhoneNumber() + "\n";
            message += "Company: " + p.getCompany() + "\n";
            message += "Gender: " + p.getGender() + "\n";
            message += "Birth Date: " + p.getBirthDate();
            showMessage(message);
            message = "";
        }*/
    }

    private void showMessage(String message)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message Information");
        alert.setContentText(message);
        alert.showAndWait();
    }

}