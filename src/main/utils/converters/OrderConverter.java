package utils.converters;

import fxmodels.OrderFx;
import models.Order;

public class OrderConverter {

    public static OrderFx convertToOrderFx(Order order){
        OrderFx orderFx = new OrderFx();
        if(order.getCar() != null){
            orderFx.setClientInfo(order.getCar().getClient().getPerson().getName() + " "
                    + order.getCar().getClient().getPerson().getSurname());
            orderFx.setCarInfo(order.getCar().getBrand() + " "
                    + order.getCar().getModel());
        }
        orderFx.setPlacedDate(order.getPlacedDate());
        orderFx.setFinishDate(order.getFinishedData());
        orderFx.setStatus(order.getStatus());
        return orderFx;
    }
}
