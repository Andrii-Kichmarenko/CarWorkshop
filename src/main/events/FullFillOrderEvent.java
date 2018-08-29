package events;

import models.Order;

public class FullFillOrderEvent {

    private Order order;

    public FullFillOrderEvent(Order filledOrder) {
        order = filledOrder;
    }

    public Order getOrder() {
        return order;
    }
}
