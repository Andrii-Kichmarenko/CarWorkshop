package controllers;

import fxmodels.ClientFx;
import fxmodels.ListClientsModel;
import fxml.Main;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.greenrobot.eventbus.EventBus;
import org.omg.CORBA.portable.ApplicationException;
import events.ChooseClientEvent;
import utils.OrderComposer;

import java.io.IOException;
import java.time.LocalDate;

public class ListClientsController extends ScreenController{

    @FXML
    private TableView<ClientFx> clientsTableView;
    @FXML
    private TableColumn<ClientFx, String> nameColumn;
    @FXML
    private TableColumn<ClientFx, String> surnameColumn;
    @FXML
    private TableColumn<ClientFx, LocalDate> birthdateColumn;
    @FXML
    private TableColumn<ClientFx, LocalDate> registrationColumn;
    @FXML
    private TableColumn<ClientFx, String> phoneNumberColumn;
    @FXML
    private TableColumn<ClientFx, String> emailColumn;

    private ListClientsModel listClientsModel;

    @FXML
    private Button nextButton;

    @FXML
    private Button cancelButton;

    public ListClientsController() {
    }

    public ListClientsController( Scene currentScene, String name, Parent parent) {
        super(currentScene, name, parent);
    }

    @FXML
    void initialize() {
        this.listClientsModel = new ListClientsModel();
        try {
            this.listClientsModel.init();
        } catch (ApplicationException e) {
 //           DialogsUtils.errorDialog(e.getMessage());
        }

        if(!listClientsModel.getClientFxObservableList().isEmpty()){
            setUpTableView();
        }else{
            clientsTableView.setPlaceholder(new Label("Clients list is empty."));
        }

        clientsTableView.setOnMouseClicked(this::getSelectedItem);
        nextButton.setOnMouseClicked(this::nextButtonAction);
        cancelButton.setOnMouseClicked(this::cancelButtonAction);
    }

    @FXML
    private void getSelectedItem(MouseEvent event){
        ClientFx n = clientsTableView.getSelectionModel().getSelectedItem();
        if(n != null){
            System.out.println(n.getName());
            this.nextButton.setDisable(false);
        }
    }

    @FXML
    private void nextButtonAction(MouseEvent event){
        System.out.println("Next_bt_Pressed");
        Integer selectedClient = clientsTableView.getSelectionModel().getSelectedItem().getIdClient();
        EventBus.getDefault().post(new ChooseClientEvent(selectedClient));

        try {
            activate("choose_car_view");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cancelButtonAction(MouseEvent event){
        try {
            activate("orders_view");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUpTableView(){
        clientsTableView.setItems(this.listClientsModel.getClientFxObservableList());

        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        surnameColumn.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());
        birthdateColumn.setCellValueFactory(cellData -> cellData.getValue().birthdayDateProperty());
        registrationColumn.setCellValueFactory(cellData -> cellData.getValue().registrationDateProperty());
        phoneNumberColumn.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
    }

}