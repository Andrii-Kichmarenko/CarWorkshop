package models;


import utils.ExtensionUtility;

import java.time.LocalDate;
import java.util.List;

public abstract class Employee extends ExtensionUtility {

    private LocalDate hireDate;
    private LocalDate firedDate;
    private List<String> foreignLanguages;

    private Person person;

    public Employee(Person person, LocalDate hireDate) {
        super();
        this.person = person;
        person.setEmployee(this);
        this.hireDate = hireDate;
    }

    public Person getPerson() { return person; }

    public LocalDate getFiredDate() {
        return firedDate;
    }

    public void setFiredDate(LocalDate firedDate) {
        this.firedDate = firedDate;
    }

    public List<String> getForeignLanguages() {
        return foreignLanguages;
    }

    public void setForeignLanguages(List<String> foreignLanguages) {
        this.foreignLanguages = foreignLanguages;
    }

    public void addForeignLanguages(String language){
        foreignLanguages.add(language);
    }
}
