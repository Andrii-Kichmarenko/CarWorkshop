package fxmodels;

import javafx.beans.property.*;

import java.time.LocalDate;

public class CarFx {

    private SimpleStringProperty vin = new SimpleStringProperty();
    private SimpleStringProperty brand = new SimpleStringProperty();
    private SimpleStringProperty model = new SimpleStringProperty();
    private SimpleStringProperty engineCapacity = new SimpleStringProperty();
    private ObjectProperty<LocalDate> purchaseDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> sellDate= new SimpleObjectProperty<>();
    private SimpleIntegerProperty idCar = new SimpleIntegerProperty();

    public String getVin() {return vin.get(); }

    public SimpleStringProperty vinProperty() { return vin; }

    public void setVin(String vin) { this.vin.set(vin); }

    public String getBrand() {
        return brand.get();
    }

    public SimpleStringProperty brandProperty() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public String getModel() {
        return model.get();
    }

    public SimpleStringProperty modelProperty() {
        return model;
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    public String getEngineCapacity() {
        return engineCapacity.get();
    }

    public SimpleStringProperty engineCapacityProperty() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity.set(engineCapacity);
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate.get();
    }

    public ObjectProperty<LocalDate> purchaseDateProperty() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate.set(purchaseDate);
    }

    public LocalDate getSellDate() {
        return sellDate.get();
    }

    public ObjectProperty<LocalDate> sellDateProperty() {
        return sellDate;
    }

    public void setSellDate(LocalDate sellDate) {
        this.sellDate.set(sellDate);
    }

    public int getIdCar() {
        return idCar.get();
    }

    public SimpleIntegerProperty idCarProperty() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar.set(idCar);
    }
}
