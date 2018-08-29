package models;

import utils.ExtensionUtility;

import java.time.LocalDate;
import java.util.ArrayList;


public class Order extends ExtensionUtility {
    public enum Status{ Done, InProcess, Placed, Canceled }

    private LocalDate finishedData;
    private LocalDate placedDate;
    private Status status;
    private Car car;

    private Mechanic mechanic;
    private Manager manager;
    private Service service;
    private ArrayList<CarPart> carParts;

    public Order(LocalDate placedData) {
        super();
        this.placedDate = placedData;
        this.status = Status.Placed;
        carParts = new ArrayList<CarPart>();
    }


    public void setManager(Manager manager){
        if(this.manager != null && this.manager != manager){
            this.manager.removeOrder(this);
        }
        this.manager = manager;
        manager.addOrder(this);
    }

    public void removeManager(){
        if(manager != null){
            manager.removeOrder(this);
            manager = null;
        }
    }

    public void setMechanic(Mechanic mechanic){
        if(this.mechanic != null && this.mechanic != mechanic){
            this.mechanic.removeOrder(this);
        }
        this.mechanic = mechanic;
        mechanic.addOrder(this);
    }

    public void removeMechanic(){
        if(mechanic != null){
            mechanic.removeOrder(this);
            mechanic = null;
        }
    }

    public void setCar(Car car) {
        if(this.car != null && this.car != car){
            this.car.removeOrder(this);
        }
        this.car = car;
        car.addOrder(this);
    }

    public void removeCar(){
        if(car != null){
            car.removeOrder(this);
            car = null;
        }
    }

    public Car getCar() {
        return car;
    }

    public void addCarPart(CarPart carPart) {
        if(!carParts.contains(carPart)) {
            carParts.add(carPart);
            carPart.setOrder(this);
        }
    }

    public void removeCarPart(CarPart carPart){
        if(carParts.contains(carPart)) {
            carParts.remove(carPart);
            carPart.removeOrder();
        }
    }

    public void setService(Service service) {
        if(this.service != null && this.service != service){
            this.service.removeOrder(this);
        }
        this.service = service;
        service.addOrder(this);
    }

    public void removeService(){
        if(service != null){
            service.removeOrder(this);
            service = null;
        }
    }

    public LocalDate getFinishedData() {
        return finishedData;
    }

    public void setFinishedData(LocalDate finishedData) {
        this.finishedData = finishedData;
    }

    public LocalDate getPlacedDate() {
        return placedDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
