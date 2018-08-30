package utils;

import events.*;
import models.Order;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class OrderComposer {

    private Integer idClient;
    private Integer idCar;
    private Integer idMechanic;


    public OrderComposer() {
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void onChooseClientEvent(ChooseClientEvent event){
        setIdClient(event.getIdClient());
    }

    @Subscribe
    public void onChooseCar(ChooseCarEvent event){
        setIdCar(event.getIdCar());
    }

    @Subscribe
    public void onChooseMechanic(ChooseMechanicEvent event){
        setIdMechaic(event.getIdMechanic());
    }

    @Subscribe
    public void onCreateOrder(CreateOrderEvent event){
        Order order = event.getOrder();
        order.setCar(ExtensionUtility.getCar(idCar));
        order.setMechanic(ExtensionUtility.getMechanic(idMechanic));
        EventBus.getDefault().post(new FilledOrderEvent(order));
    }

    private void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    public void setIdMechaic(Integer idMechaic) {
        this.idMechanic = idMechaic;
    }
}
