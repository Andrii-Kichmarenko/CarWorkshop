package controllers;

import FxModels.ClientFx;
import fxml.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Car;
import models.Client;

import java.io.IOException;
import java.util.HashMap;

public class ScreenController {
    private static HashMap<String, Parent> screenMap = new HashMap<>();
    private static Scene currentScene;
    private Main ref;
    private ClientFx selectedClient;
    private Car selectedCar;


    public ScreenController() {
    }

    public ScreenController(Scene currentScene, String name, Parent parent) {
        this.ref=ref;
        this.currentScene = currentScene;
        screenMap.put(name, parent);
    }

    public static void addScreen(String name, Parent parent){
        screenMap.put(name, parent);
    }

    public static void removeScreen(String name){
        screenMap.remove(name);
    }

    public void activate(String name) throws IOException {
        currentScene.setRoot( screenMap.get(name));
        currentScene.getStylesheets().add("main.css");
    }

    public ClientFx getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(ClientFx selectedClient) {
        this.selectedClient = selectedClient;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
}
