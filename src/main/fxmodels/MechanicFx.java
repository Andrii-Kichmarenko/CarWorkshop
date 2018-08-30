package fxmodels;

import javafx.beans.property.*;
import models.Mechanic;

import java.time.LocalDate;

public class MechanicFx {

    private IntegerProperty idMechanic = new SimpleIntegerProperty();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty surname= new SimpleStringProperty();
    private SimpleStringProperty phoneNumber = new SimpleStringProperty();
    private ObjectProperty<Mechanic.MechanicCategory> category = new SimpleObjectProperty<>();

    public int getIdMechanic() {
        return idMechanic.get();
    }

    public IntegerProperty idMechanicProperty() {
        return idMechanic;
    }

    public void setIdMechanic(int idMechanic) {
        this.idMechanic.set(idMechanic);
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

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public Mechanic.MechanicCategory getCategory() {
        return category.get();
    }

    public ObjectProperty<Mechanic.MechanicCategory> categoryProperty() {
        return category;
    }

    public void setCategory(Mechanic.MechanicCategory category) {
        this.category.set(category);
    }
}
