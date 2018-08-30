package events;

import models.Order;

public class FilledOrderEvent {

    private Order order;

    public FilledOrderEvent(Order filledOrder) {
        order = filledOrder;
    }

    public Order getOrder() {
        return order;
    }
}
