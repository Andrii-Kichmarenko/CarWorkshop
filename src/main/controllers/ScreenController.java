package controllers;

import fxmodels.ClientFx;
import fxml.Main;
import javafx.scene.Parent;
import javafx.scene.Scene;
import models.Car;

import java.io.IOException;
import java.util.HashMap;

public class ScreenController {

    private static HashMap<String, Parent> screenMap = new HashMap<>();
    private static Scene currentScene;
    private Main ref;
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

    public void activate(String name) throws IOException {
        currentScene.setRoot( screenMap.get(name));
        currentScene.getStylesheets().add("main.css");
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
}
