package models;


import java.time.LocalDate;
import java.util.ArrayList;


public class Manager extends Employee {

    private boolean higherEducation;
    private double bonusForOrder;

    private ArrayList<Order> managedOrders;

    private Manager(Person person, LocalDate hireDate, boolean higherEducation, double bonusForOrder) {
        super(person, hireDate);
        this.higherEducation = higherEducation;
        this.bonusForOrder = bonusForOrder;
        managedOrders = new ArrayList<>();
    }

    public static Manager createManager(Person person, LocalDate hireDate, boolean higherEducation, double bonusForOrder) throws Exception {
        if(person == null){
            throw new Exception("Person doesn't exist.");
        }
        Manager manager = new Manager(person, hireDate, higherEducation, bonusForOrder);
        return manager;
    }

    public void addOrder(Order order) {
        if(!managedOrders.contains(order)) {
            managedOrders.add(order);
            order.setManager(this);
        }
    }

    public void removeOrder(Order order) {
        if (managedOrders.contains(order)) {
            managedOrders.remove(order);
            order.removeManager();
        }
    }

    public double getBonusForOrder() {
        return bonusForOrder;
    }

    public void setBonusForOrder(double bonusForOrder) {
        this.bonusForOrder = bonusForOrder;
    }
}
