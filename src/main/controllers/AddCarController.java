package controllers;

import events.AddCarEvent;
import events.ChooseClientEvent;
import events.OpenAddCarEvent;
import fxmodels.CarFx;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Car;
import models.Client;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import utils.ExtensionUtility;
import utils.converters.CarConverter;

import java.io.IOException;

public class AddCarController extends SecondScreenController {

    @FXML
    private Label clientInfoLable;
    @FXML
    private TextField vinTextField;
    @FXML
    private TextField brandTextField;
    @FXML
    private TextField modelTextField;
    @FXML
    private TextField engineCapacityTextField;
    @FXML
    private DatePicker purchaseDatePicker;
    @FXML
    private Label errorLable;

    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;

    private Client client;

    public AddCarController() {
    }

    public AddCarController(Scene currentScene, String name, Parent parent) {
        super(currentScene, name, parent);
    }

    @FXML
    void initialize(){
        this.cancelButton.setOnMouseClicked(this::cancelButtonAction);
        this.saveButton.setOnMouseClicked(this::saveButtonAction);

        EventBus.getDefault().register(this);
    }

    private void saveButtonAction(MouseEvent mouseEvent) {
        if(isPassRequirements()){
            Car newConvertedCar = CarConverter.convertToCar(createCarFx());
            newConvertedCar.setClient(client);
            ((Stage) cancelButton.getScene().getWindow()).close();
            EventBus.getDefault().post(new AddCarEvent(newConvertedCar));
        }
    }

    @Subscribe
    public void onChooseClientEvent(ChooseClientEvent event){
        client = (event.getClient());
        clientInfoLable.setText(client.getPerson().getName() + " "
                + client.getPerson().getSurname());
    }

    @Subscribe
    public void onOpenAddCarEvent(OpenAddCarEvent event) {
        try {
            openCounter+=1;
            activate("add_car_form_view");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CarFx createCarFx() {
        CarFx newCarFx = new CarFx();
        newCarFx.setVin(vinTextField.getText());
        newCarFx.setBrand(brandTextField.getText());
        newCarFx.setModel(modelTextField.getText());
        newCarFx.setEngineCapacity(engineCapacityTextField.getText());
        newCarFx.setPurchaseDate(purchaseDatePicker.getValue());
        return newCarFx;
    }

    private boolean isPassRequirements() {
        if(vinTextField.getCharacters().length() != 17){
            errorLable.setText("VIN number is composed of 17 characters");
            return false;
        }
        if(hasWhitespacesOrEmpty(brandTextField.getCharacters()) ||
                hasWhitespacesOrEmpty(modelTextField.getCharacters()) ||
                        hasWhitespacesOrEmpty(engineCapacityTextField.getCharacters())){
            errorLable.setText("Please fill required fields.");
            return false;
        }
        return true;
    }

    private boolean hasWhitespacesOrEmpty(CharSequence charSequence){
        if(charSequence.length() == 0 )
            return true;
        if(charSequence.toString().trim().length() == 0 )
            return true;
        return false;
    }

    private void cancelButtonAction(MouseEvent mouseEvent) {
        ((Stage) cancelButton.getScene().getWindow()).close();
        System.out.println(openCounter);
    }
}