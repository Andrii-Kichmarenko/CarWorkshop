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

    public ScreenController() {
    }

    public ScreenController(Scene currentScene, String name, Parent parent) {
        this.currentScene = currentScene;
        screenMap.put(name, parent);
    }

    public static void addScreen(String name, Parent parent){
        screenMap.put(name, parent);
    }

    public void activate(String name) throws IOException {
        currentScene.setRoot( screenMap.get(name));
    }

}
