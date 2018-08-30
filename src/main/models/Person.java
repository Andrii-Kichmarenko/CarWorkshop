package models;

import utils.ExtensionUtility;

import java.time.LocalDate;
import java.util.ArrayList;

public class Person extends ExtensionUtility {

    private static int idCounter = 0;

    private int idPerson;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String phoneNumber;

    private Employee employee;
    private Client client;

    public Person(String name, String surname, LocalDate birthDate) {
        super();
        idPerson = idCounter++;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public void setEmployee(Client client){
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIdPerson() {
        return idPerson;
    }
}
