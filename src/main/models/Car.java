package models;

import utils.ExtensionUtility;

import java.time.LocalDate;
import java.util.ArrayList;

public class Car extends ExtensionUtility {

    public static int VINlength = 17;
    private static int idCounter = 0;

    private int idCar;
    private String VIN; //17characters
    private String brand;
    private String model;
    private double engineSpacity;
    private LocalDate purchaseDate;
    private LocalDate sellDate;
    private ArrayList<Insurance> insurances;

    private ArrayList<Order> orders;
    private Client client;

    public Car(String VIN, String brand, String model, double engineSpacity, LocalDate purchaseDate) {
        super();
        idCar = idCounter++;
        if(VIN.length() != VINlength){
            throw new IllegalArgumentException("VIN must be 17 characters");
        }
        this.VIN = VIN;
        this.brand = brand;
        this.model = model;
        this.engineSpacity = engineSpacity;
        this.purchaseDate = purchaseDate;

        insurances =  new ArrayList<Insurance>();
        orders = new ArrayList<Order>();
    }

    public void setClient(Client client){
        if(this.client != null && this.client != client){
            this.client.removeCar(this);
        }
        this.client = client;
        client.addCar(this);
    }

    public void removeClient(){
        if(client != null){
            client.removeCar(this);
            client = null;
        }
    }

    public void addOrder(Order order) {
        if(!orders.contains(order)) {
            orders.add(order);
            order.setCar(this);
        }
    }

    public void removeOrder(Order order) {
        if(orders.contains(order)) {
            orders.remove(order);
            order.removeCar();
        }
    }

    public int getIdCar() { return idCar; }

    public String getVIN() {
        return VIN;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineSpacity() {
        return engineSpacity;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getSellDate() {
        return sellDate;
    }

    public void setSellDate(LocalDate sellDate) {
        this.sellDate = sellDate;
    }

    public Client getClient() {
        return client;
    }

    public void addInsurance(LocalDate fromDate, LocalDate toDate) {
        Insurance newInsurance = new Insurance(fromDate, toDate);
        insurances.add(newInsurance);
    }

    public void removeInsurance(Insurance targetInsurance){
        if(insurances.contains(targetInsurance)){
            insurances.remove(targetInsurance);
        }
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }



    public class Insurance extends ExtensionUtility {
        private LocalDate fromDate;
        private LocalDate toDate;

        public Insurance(LocalDate fromDate, LocalDate toDate) {
            super();
            this.fromDate = fromDate;
            this.toDate = toDate;
        }
    }
}
