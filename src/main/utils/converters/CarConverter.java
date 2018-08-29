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
        carFx.setIdClient(car.getClient().getPerson().getIdPerson());
        return carFx;
    }
}
