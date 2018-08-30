package utils.converters;

import fxmodels.CarFx;
import models.Car;

public class CarConverter {
    public static CarFx convertToCarFx(Car car){
        CarFx carFx = new CarFx();
        carFx.setBrand(car.getBrand());
        carFx.setModel(car.getModel());
        carFx.setEngineCapacity(String.valueOf(car.getEngineSpacity()));
        carFx.setPurchaseDate(car.getPurchaseDate());
        carFx.setSellDate(car.getSellDate());
        carFx.setIdCar(car.getIdCar());
        return carFx;
    }

    public static Car convertToCar(CarFx carFx){
        Car car = new Car(
            carFx.getVin(),
            carFx.getBrand(),
            carFx.getModel(),
            Double.valueOf(carFx.getEngineCapacity()),
            carFx.getPurchaseDate()
        );
        return car;
    }
}
