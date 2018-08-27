package models;

import utils.ExtensionUtility;

public class CarPart extends ExtensionUtility {

    private String number;
    private String name;
    private double price;
    private String additionAttention;

    private Order order;

    public CarPart(String number, String name, double price) {
        super();
        this.number = number;
        this.name = name;
        this.price = price;
    }

    public void setOrder(Order order){
        if(this.order != null && this.order != order){
            this.order.removeCarPart(this);
        }
        this.order = order;
        order.addCarPart(this);
    }

    public void removeOrder(){
        if(order != null){
            order.removeCarPart(this);
            order = null;
        }
    }

    public String getAdditionAttention() {
        return additionAttention;
    }

    public void setAdditionAttention(String additionAttention) {
        this.additionAttention = additionAttention;
    }
}
