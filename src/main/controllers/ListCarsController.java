package controllers;

import events.AddCarEvent;
import events.ChooseCarEvent;
import events.OpenAddCarEvent;
import fxml.Main;
import fxmodels.CarFx;
import fxmodels.ListCarsModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.omg.CORBA.portable.ApplicationException;
import events.ChooseClientEvent;
import utils.ExtensionUtility;

import java.io.IOException;
import java.time.LocalDate;

public class ListCarsController extends ScreenController{

    @FXML
    private TableView<CarFx> carsTableView;
    @FXML
    private TableColumn<CarFx, String> brandColumn;
    @FXML
    private TableColumn<CarFx, String> modelColumn;
    @FXML
    private TableColumn<CarFx, String> engineCapacityColumn;
    @FXML
    private TableColumn<CarFx, LocalDate> purchaseDateColumn;
    @FXML
    private TableColumn<CarFx, LocalDate> sellDateColumn;

    private ListCarsModel listCarsModel;

    @FXML
    private Button nextButton;
    @FXML
    private Button addCarButton;
    @FXML
    private Button cancelButton;

    private boolean isTableEmpty;

    public ListCarsController() {
    }

    public ListCarsController(Scene currentScene, String name, Parent parent) {
        super(currentScene, name, parent);
    }

    @FXML
    void initialize() {
        this.listCarsModel = new ListCarsModel();
        try {
            this.listCarsModel.init();
        } catch (ApplicationException e) {
            //           DialogsUtils.errorDialog(e.getMessage());
        }
        isTableEmpty = listCarsModel.getCarFxObservableList().isEmpty();
        if(!isTableEmpty){
            setUpTableView();
        }else{
            carsTableView.setPlaceholder(new Label("Client hasn't registered cars. Press \"Add Car\" to add new one."));
        }

        this.carsTableView.setOnMouseClicked(this::getSelectedItem);
        this.nextButton.setOnMouseClicked(this::nextButtonAction);
        this.addCarButton.setOnMouseClicked(this::addCarButtonAction);
        this.cancelButton.setOnMouseClicked(this::cancelButtonAction);

        // init eventBus
        EventBus.getDefault().register(this);
    }

    private void addCarButtonAction(MouseEvent mouseEvent) {
        EventBus.getDefault().post(new OpenAddCarEvent());
    }

    @FXML
    private void getSelectedItem(MouseEvent event){
        CarFx n = carsTableView.getSelectionModel().getSelectedItem();
        if(n != null){
            System.out.println(n.getBrand());
            this.nextButton.setDisable(false);
        }
    }

    @FXML
    private void nextButtonAction(MouseEvent event) {
        System.out.println("Next_bt_Pressed");
        Integer selectedCar = carsTableView.getSelectionModel().getSelectedItem().getIdCar();
        EventBus.getDefault().post(new ChooseCarEvent(selectedCar));

        try {
            activate("choose_mechanic_view");
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
        this.carsTableView.setItems(this.listCarsModel.getCarFxObservableList());

        this.brandColumn.setCellValueFactory(cellData -> cellData.getValue().brandProperty());
        this.modelColumn.setCellValueFactory(cellData -> cellData.getValue().modelProperty());
        this.engineCapacityColumn.setCellValueFactory(cellData -> cellData.getValue().engineCapacityProperty());
        this.purchaseDateColumn.setCellValueFactory(cellData -> cellData.getValue().purchaseDateProperty());
        this.sellDateColumn.setCellValueFactory(cellData -> cellData.getValue().sellDateProperty());
    }

    @Subscribe
    public void onChooseClient(ChooseClientEvent event){
        launchCarFilter(event.getIdClient());
    }

    @Subscribe
    public void onAddCarEvent(AddCarEvent event){
        listCarsModel.addCar(event.getNewCar());
    }

    private void launchCarFilter(Integer idClient){
        listCarsModel.filterCarList(idClient);
        if(isTableEmpty){
            setUpTableView();
        }
    }
}