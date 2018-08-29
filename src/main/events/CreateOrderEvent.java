package events;

import models.Order;

import java.time.LocalDate;

public class CreateOrderEvent {

    private Order order;

    public CreateOrderEvent() {
        this.order = new Order(LocalDate.now());
    }

    public Order getOrder() {
        return order;
    }
}
