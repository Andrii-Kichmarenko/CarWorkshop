package models;


import java.time.LocalDate;
import java.util.ArrayList;


public class Mechanic extends Employee {

    public enum MechanicCategory {FIRST, SECOND, THIRD, FOURTH; }

    private MechanicCategory category;
    private double monthlySalaryBonus;

    private ArrayList<Order> assignedOrders;

    private Mechanic(Person person, LocalDate hireDate, MechanicCategory category, double monthlySalaryBonus) {
        super(person, hireDate);
        this.category = category;
        this.monthlySalaryBonus = monthlySalaryBonus;
        assignedOrders = new ArrayList<>();
    }

    public static Mechanic createMechanic(Person person, LocalDate hireDate, MechanicCategory category, double monthlySalaryBonus) throws Exception {
        if(person == null){
            throw new Exception("Person doesn't exist.");
        }
        Mechanic mechanic = new Mechanic(person, hireDate, category, monthlySalaryBonus);
        person.addEmployee(mechanic);
        return mechanic;
    }

    public void addOrder(Order order) {
        if(!assignedOrders.contains(order)) {
            assignedOrders.add(order);
            order.setMechanic(this);
        }
    }

    public void removeOrder(Order order) {
        if (assignedOrders.contains(order)) {
            assignedOrders.remove(order);
            order.removeMechanic();
        }
    }

    public MechanicCategory getCategory() {
        return category;
    }

    public void setCategory(MechanicCategory category) {
        this.category = category;
    }

    public double getMonthlySalaryBonus() {
        return monthlySalaryBonus;
    }

    public void setMonthlySalaryBonus(double monthlySalaryBonus) {
        this.monthlySalaryBonus = monthlySalaryBonus;
    }
}
