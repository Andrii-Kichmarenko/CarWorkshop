package fxmodels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Car;
import org.omg.CORBA.portable.ApplicationException;
import utils.ExtensionUtility;
import utils.converters.CarConverter;

import java.util.ArrayList;
import java.util.List;

public class ListCarsModel {
    private ObservableList<CarFx> carFxObservableList = FXCollections.observableArrayList();
    private List<CarFx> carsFxList = new ArrayList<>();

    public void init() throws ApplicationException {
        List<Car> carsOrigin = ExtensionUtility.getExtension(Car.class);
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

    public void filterCarList(Integer idClient) {

        // ХУЙОВО
        List<CarFx> filteredCarsFxList = new ArrayList<>(carsFxList);
        filteredCarsFxList.removeIf(carFx -> carFx.idCarProperty().get() != idClient);
        this.carFxObservableList.setAll(filteredCarsFxList);
    }
}