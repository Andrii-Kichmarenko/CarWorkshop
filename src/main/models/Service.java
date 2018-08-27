package models;

import utils.ExtensionUtility;
import java.util.ArrayList;

public abstract class Service extends ExtensionUtility {

    private int timePeriod;  //in month
    private int distancePeriod;
    private Mechanic.MechanicCategory mechanicCategory;
    private double price;

    private ArrayList<Order> orders;

    public Service() {
        super();
    }

    public int getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(int timePeriod) {
        this.timePeriod = timePeriod;
    }

    public int getDistancePeriod() {
        return distancePeriod;
    }

    public void setDistancePeriod(int distancePeriod) {
        this.distancePeriod = distancePeriod;
    }

    public Mechanic.MechanicCategory getMechanicCategory() {
        return mechanicCategory;
    }

    public void setMechanicCategory(Mechanic.MechanicCategory mechanicCategory) {
        this.mechanicCategory = mechanicCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void removeOrder(Order order) {
        if(orders.contains(order)) {
            orders.remove(order);
            order.removeService();
        }
    }

    public void addOrder(Order order) {
        if(!orders.contains(order)) {
            orders.add(order);
            order.setService(this);
        }
    }
}
