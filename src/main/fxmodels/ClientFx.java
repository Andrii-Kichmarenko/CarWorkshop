package fxmodels;

import javafx.beans.property.*;
import models.Client;

import java.time.LocalDate;

public class ClientFx {

    private ObjectProperty<Client> client = new SimpleObjectProperty();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty surname= new SimpleStringProperty();
    private ObjectProperty<LocalDate> birthdayDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> registrationDate= new SimpleObjectProperty<>();
    private SimpleStringProperty phoneNumber = new SimpleStringProperty();
    private SimpleStringProperty email = new SimpleStringProperty();

    public Client getClient() {
        return client.get();
    }

    public ObjectProperty<Client> clientProperty() {
        return client;
    }

    public void setClient(Client client) {
        this.client.set(client);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate.get();
    }

    public ObjectProperty<LocalDate> birthdayDateProperty() {
        return birthdayDate;
    }

    public void setBirthdayDate(LocalDate birthdayDate) {
        this.birthdayDate.set(birthdayDate);
    }

    public LocalDate getRegistrationDate() {
        return registrationDate.get();
    }

    public ObjectProperty<LocalDate> registrationDateProperty() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate.set(registrationDate);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

}
