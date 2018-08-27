package utils.converters;

import FxModels.CarFx;
import FxModels.ClientFx;
import models.Car;
import models.Client;

public class ConverterCar {
    public static CarFx convertToCarFx(Car car){
        CarFx carFx = new CarFx();
        carFx.setBrand(car.getBrand());
        carFx.setModel(car.getModel());
        carFx.setEngineCapacity(String.valueOf(car.getEngineSpacity()));
        carFx.setPurchaseDate(car.getPurchaseDate());
        carFx.setSellDate(car.getSellDate());
        return carFx;
    }
}
