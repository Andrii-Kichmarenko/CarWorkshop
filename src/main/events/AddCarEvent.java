package events;

import models.Car;

public class AddCarEvent {

    private Car newCar;

    public AddCarEvent(Car newCar) {
        this.newCar = newCar;
    }

    public Car getNewCar() {
        return newCar;
    }
}
