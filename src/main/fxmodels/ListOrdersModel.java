package fxmodels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Order;
import org.omg.CORBA.portable.ApplicationException;
import utils.ExtensionUtility;
import utils.converters.OrderConverter;

import java.util.ArrayList;
import java.util.List;

public class ListOrdersModel {

    private ObservableList<OrderFx> orderFxObservableList = FXCollections.observableArrayList();
    private List<OrderFx> orderFxList = new ArrayList<>();
    List<Order> ordersOrigin;

    public void init()throws ApplicationException{
        ordersOrigin = ExtensionUtility.getExtension(Order.class);
        if(ordersOrigin  != null){
            ordersOrigin.forEach(order -> {
                this.orderFxList.add(OrderConverter.convertToOrderFx(order));
            });
            orderFxObservableList.setAll(orderFxList);
        }
    }

    public ObservableList<OrderFx> getOrderFxObservableList() {
        return orderFxObservableList;
    }

    public void refreshList() {
        orderFxList.clear();
        ordersOrigin = ExtensionUtility.getExtension(Order.class);
        ordersOrigin.forEach(order -> {
            this.orderFxList.add(OrderConverter.convertToOrderFx(order));
        });
        orderFxObservableList.setAll(orderFxList);
    }
}