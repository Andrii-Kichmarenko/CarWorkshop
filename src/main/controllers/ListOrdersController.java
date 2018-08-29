package controllers;

import fxmodels.ListOrdersModel;
import fxmodels.OrderFx;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import models.Order;
import org.omg.CORBA.portable.ApplicationException;

import java.io.IOException;
import java.time.LocalDate;

public class ListOrdersController extends ScreenController {

    @FXML
    private TableView<OrderFx> ordersTableView;
    @FXML
    private TableColumn<OrderFx, String> clientInfoColumn;
    @FXML
    private TableColumn<OrderFx, String> carInfoColumn;
    @FXML
    private TableColumn<OrderFx, LocalDate> placedDateColumn;
    @FXML
    private TableColumn<OrderFx, LocalDate> finishedDateColumn;
    @FXML
    private TableColumn<OrderFx, Order.Status> statusColumn;

    private ListOrdersModel listOrdersModel;

    @FXML
    private Button addOrderButton;

    public ListOrdersController() {
    }

    public ListOrdersController(Scene currentScene, String name, Parent parent) {
        super(currentScene, name, parent);
    }

    @FXML
    void initialize(){
        listOrdersModel = new ListOrdersModel();
        try {
            listOrdersModel.init();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
        if(!listOrdersModel.getOrderFxObservableList().isEmpty()){
            setUpTableView();
        }else{
            ordersTableView.setPlaceholder(new Label("Orders list is empty. Press \"Add order\" button to create new one."));
        }

        addOrderButton.setOnMouseClicked(this::addOrderButtonAction);
    }

    @FXML
    private void addOrderButtonAction(MouseEvent event) {
        System.out.println("AddOrder_bt_Pressed");
        try {
            activate("choose_client_view");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUpTableView(){
        ordersTableView.setItems(listOrdersModel.getOrderFxObservableList());

        clientInfoColumn.setCellValueFactory(cellData -> cellData.getValue().clientInfoProperty());
        carInfoColumn.setCellValueFactory(cellData -> cellData.getValue().carInfoProperty());
        placedDateColumn.setCellValueFactory(cellData -> cellData.getValue().placedDateProperty());
        finishedDateColumn.setCellValueFactory(cellData -> cellData.getValue().placedDateProperty());
    }
}
