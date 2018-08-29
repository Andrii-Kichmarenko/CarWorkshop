package fxmodels;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import models.Order;

import java.time.LocalDate;

public class OrderFx {

    private SimpleStringProperty clientInfo = new SimpleStringProperty();
    private SimpleStringProperty carInfo = new SimpleStringProperty();
    private ObjectProperty<LocalDate> placedDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> finishDate= new SimpleObjectProperty<>();
    private ObjectProperty<Order.Status> status = new SimpleObjectProperty<>();

    public String getClientInfo() {
        return clientInfo.get();
    }

    public SimpleStringProperty clientInfoProperty() {
        return clientInfo;
    }

    public void setClientInfo(String clientInfo) {
        this.clientInfo.set(clientInfo);
    }

    public String getCarInfo() {
        return carInfo.get();
    }

    public SimpleStringProperty carInfoProperty() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo.set(carInfo);
    }

    public LocalDate getPlacedDate() {
        return placedDate.get();
    }

    public ObjectProperty<LocalDate> placedDateProperty() {
        return placedDate;
    }

    public void setPlacedDate(LocalDate placedDate) {
        this.placedDate.set(placedDate);
    }

    public LocalDate getFinishDate() {
        return finishDate.get();
    }

    public ObjectProperty<LocalDate> finishDateProperty() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate.set(finishDate);
    }

    public Order.Status getStatus() {
        return status.get();
    }

    public ObjectProperty<Order.Status> statusProperty() {
        return status;
    }

    public void setStatus(Order.Status status) {
        this.status.set(status);
    }
}
