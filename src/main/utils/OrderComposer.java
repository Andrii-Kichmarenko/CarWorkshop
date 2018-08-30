package utils;

import events.ChooseCarEvent;
import events.ChooseMechanicEvent;
import events.CreateOrderEvent;
import events.FilledOrderEvent;
import models.Order;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class OrderComposer {

    private Integer idCar;
    private Integer idMechaic;

    public OrderComposer() {
        EventBus.getDefault().register(this);
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
        order.setMechanic(ExtensionUtility.getMechanic(idMechaic));
        EventBus.getDefault().post(new FilledOrderEvent(order));
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    public void setIdMechaic(Integer idMechaic) {
        this.idMechaic = idMechaic;
    }
}
