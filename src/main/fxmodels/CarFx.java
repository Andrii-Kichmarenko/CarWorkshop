package fxmodels;

import javafx.beans.property.*;

import java.time.LocalDate;

public class CarFx {

    //TODO

    private SimpleStringProperty brand = new SimpleStringProperty();
    private SimpleStringProperty model = new SimpleStringProperty();
    private SimpleStringProperty engineCapacity = new SimpleStringProperty();
    private ObjectProperty<LocalDate> purchaseDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> sellDate= new SimpleObjectProperty<>();

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
}
