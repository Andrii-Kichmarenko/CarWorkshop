package fxmodels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Car;
import org.omg.CORBA.portable.ApplicationException;
import utils.ExtensionUtility;
import utils.converters.ConverterCar;

import java.util.ArrayList;
import java.util.List;

public class ListCarsModel {
    private ObservableList<CarFx> carFxObservableList = FXCollections.observableArrayList();

    private List<CarFx> carsFxList = new ArrayList<>();

    public void init(ClientFx selectedClient) throws ApplicationException {
        Class instance = Car.class;
        List<Car> cars = ExtensionUtility.getExtension(instance);
        carsFxList.clear();
        cars.forEach(car -> {
//            if (car.getClient().getId() == selectedClient.getId()) {
                this.carsFxList.add(ConverterCar.convertToCarFx(car));
//            }
        });
        this.carFxObservableList.setAll(carsFxList);
    }

    public ObservableList<CarFx> getCarFxObservableList() {
        return carFxObservableList;
    }

    public void setCarFxObservableList(ObservableList<CarFx> carFxObservableList) {
        this.carFxObservableList = carFxObservableList;
    }
}