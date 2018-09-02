package fxmodels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Car;
import models.Client;
import org.omg.CORBA.portable.ApplicationException;
import utils.ExtensionUtility;
import utils.converters.CarConverter;

import java.util.ArrayList;
import java.util.List;

public class ListCarsModel {
    private ObservableList<CarFx> carFxObservableList = FXCollections.observableArrayList();
    private List<CarFx> carsFxList = new ArrayList<>();
    List<Car> carsOrigin;

    public void init() throws ApplicationException {
        carsOrigin = ExtensionUtility.getExtension(Car.class);
        if(carsOrigin != null){
            carsOrigin.forEach(car -> {
                this.carsFxList.add(CarConverter.convertToCarFx(car));
            });
            this.carFxObservableList.setAll(carsFxList);
        }
    }

    public ObservableList<CarFx> getCarFxObservableList() {
        return carFxObservableList;
    }

    public void setCarFxObservableList(ObservableList<CarFx> carFxObservableList) {
        this.carFxObservableList = carFxObservableList;
    }

    public void updateCarList(Client client) {
        carsFxList.clear();
        ArrayList<Car> cars = client.getCars();
        if(!cars.isEmpty()){
            cars.forEach(car -> { carsFxList.add(CarConverter.convertToCarFx(car)); });
            this.carFxObservableList.setAll(carsFxList);
        }
    }

    public void addCar(Car newCar) {
        CarFx newCarFx = CarConverter.convertToCarFx(newCar);
        this.carsFxList.add(newCarFx);
        this.carFxObservableList.add(newCarFx);
    }
}