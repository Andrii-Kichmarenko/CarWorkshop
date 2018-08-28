package fxmodels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Car;
import org.omg.CORBA.portable.ApplicationException;
import utils.ExtensionUtility;
import utils.converters.ConverterCar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListCarsModel {
    private ObservableList<CarFx> carFxObservableList = FXCollections.observableArrayList();
    private List<CarFx> carsFxList = new ArrayList<>();

    public void init(ClientFx selectedClient) throws ApplicationException {
        List<Car> carsOrigin = ExtensionUtility.getExtension(Car.class);
        carsFxList.clear();
        carsOrigin.forEach(car -> {
            this.carsFxList.add(ConverterCar.convertToCarFx(car));
        });
        this.carFxObservableList.setAll(carsFxList);
    }

    public ObservableList<CarFx> getCarFxObservableList() {
        return carFxObservableList;
    }

    public void setCarFxObservableList(ObservableList<CarFx> carFxObservableList) {
        this.carFxObservableList = carFxObservableList;
    }

    public void filterCarList(Integer idClient) {
        List<CarFx> filteredCarsFxList = new ArrayList<>(carsFxList);
        filteredCarsFxList.removeIf(carFx -> carFx.idClientProperty().get() != idClient);
        this.carFxObservableList.setAll(filteredCarsFxList);
    }
}