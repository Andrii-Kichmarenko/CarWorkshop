package controllers;

import events.ChooseMechanicEvent;
import events.CreateOrderEvent;
import fxmodels.ListMechanicsModel;
import fxmodels.MechanicFx;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import models.Mechanic;
import org.greenrobot.eventbus.EventBus;
import org.omg.CORBA.portable.ApplicationException;

import java.io.IOException;

public class ListMechanicsController extends ScreenController{

    @FXML
    private TableView<MechanicFx> mechanicsTableView;
    @FXML
    private TableColumn<MechanicFx, String> nameColumn;
    @FXML
    private TableColumn<MechanicFx, String> surnameColumn;
    @FXML
    private TableColumn<MechanicFx, String> phoneNumberColumn;
    @FXML
    private TableColumn<MechanicFx, Mechanic.MechanicCategory> categoryColumn;

    private ListMechanicsModel listMechanicsModel;

    @FXML
    private Button nextButton;

    @FXML
    private Button cancelButton;


    public ListMechanicsController() {
    }

    public ListMechanicsController(Scene currentScene, String name, Parent parent) {
        super(currentScene, name, parent);
    }

    @FXML
    void initialize() {
        this.listMechanicsModel = new ListMechanicsModel();
        try {
            this.listMechanicsModel.init();
        } catch (ApplicationException e) {
            // DialogsUtils.errorDialog(e.getMessage());
        }

        if(!listMechanicsModel.getMechanicsFxObservableList().isEmpty()){
            setUpTableView();
        }else{
            mechanicsTableView.setPlaceholder(new Label("Mechanics list is empty."));
        }

        mechanicsTableView.setOnMouseClicked(this::getSelectedItem);
        nextButton.setOnMouseClicked(this::nextButtonAction);
        cancelButton.setOnMouseClicked(this::cancelButtonAction);
    }

    @FXML
    private void getSelectedItem(MouseEvent event){
        MechanicFx n = mechanicsTableView.getSelectionModel().getSelectedItem();
        if(n != null){
            System.out.println(n.getName());
            this.nextButton.setDisable(false);
        }
    }

    @FXML
    private void nextButtonAction(MouseEvent event){
        System.out.println("Next_bt_Pressed");
        Integer selectedMechanic = mechanicsTableView.getSelectionModel().getSelectedItem().getIdMechanic();
        EventBus.getDefault().post(new ChooseMechanicEvent(selectedMechanic));
        EventBus.getDefault().post(new CreateOrderEvent());

        try {
            activate("orders_view");
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
        mechanicsTableView.setItems(this.listMechanicsModel.getMechanicsFxObservableList());

        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        surnameColumn.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());
        phoneNumberColumn.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
        categoryColumn.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
    }
}