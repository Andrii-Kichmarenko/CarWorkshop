package models;


import utils.ExtensionUtility;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Client extends ExtensionUtility implements Serializable {

    private LocalDate registrationDate;
    private String emailAdress;

    private List<Car> cars;
    private Person person;

    private Client (Person person, LocalDate registrationDate) {
        super();
        this.person = person;
        this.registrationDate = registrationDate;
        cars = new ArrayList<>();
    }

    public static Client createClient(Person person, LocalDate registrationDate ) throws Exception {
        if(person == null) {
            throw new Exception("Person doesn't exist.");
        }
        Client client = new Client(person, registrationDate);
        person.setEmployee(client);
        return client;
    }

    public void addCar(Car car){
        if(!cars.contains(car)) {
            cars.add(car);
            car.setClient(this);
        }
    }

    public void removeCar(Car car){
        if(cars.contains(car)) {
            cars.remove(car);
            car.removeClient();
        }
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
