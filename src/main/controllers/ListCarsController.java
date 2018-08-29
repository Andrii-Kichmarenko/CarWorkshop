package controllers;

import fxmodels.CarFx;
import fxmodels.ListCarsModel;
import fxml.Main;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.omg.CORBA.portable.ApplicationException;
import events.ChooseClientEvent;

import java.io.IOException;
import java.time.LocalDate;

public class ListCarsController extends ScreenController{

    @FXML
    private TableView<CarFx> carsTableView;
    @FXML
    private TableColumn<CarFx, String> BrandColumn;
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
    private Button cancelButton;

    public static ListCarsController ref;

    public ListCarsController() {
    }

    public ListCarsController(Scene currentScene, String name, Parent parent) {
        super(currentScene, name, parent);
        ref = this;
    }

    @FXML
    void initialize() {
        this.listCarsModel = new ListCarsModel();
//        if(getSelectedClient() != null){
            try {
                this.listCarsModel.init(getSelectedClient());
            } catch (ApplicationException e) {
                //           DialogsUtils.errorDialog(e.getMessage());
            }

            this.carsTableView.setItems(this.listCarsModel.getCarFxObservableList());

            this.BrandColumn.setCellValueFactory(cellData -> cellData.getValue().brandProperty());
            this.modelColumn.setCellValueFactory(cellData -> cellData.getValue().modelProperty());
            this.engineCapacityColumn.setCellValueFactory(cellData -> cellData.getValue().engineCapacityProperty());
            this.purchaseDateColumn.setCellValueFactory(cellData -> cellData.getValue().purchaseDateProperty());
            this.sellDateColumn.setCellValueFactory(cellData -> cellData.getValue().sellDateProperty());

            this.carsTableView.setOnMouseClicked(this::getSelectedItem);
            this.nextButton.setOnMouseClicked(this::nextButtonAction);
            this.cancelButton.setOnMouseClicked(this::cancelButtonAction);

        // init eventBus
        EventBus.getDefault().register(this);
//        }
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
        if(carsTableView.getSelectionModel().getSelectedItem() != null)
            System.out.println("Next_bt_Pressed");
        try {
            activate("Choose mechanic");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cancelButtonAction(MouseEvent event){
        Main.saveAndFinish();
    }

    public static ListCarsController getController(){
        return ref;
    }

    @Subscribe
    public void onChooseClient(ChooseClientEvent event){
        launchCarFilter(event.getIdClient());
    }

    private void launchCarFilter(Integer idClient){
        listCarsModel.filterCarList(idClient);
    }
}