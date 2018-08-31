package controllers;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class SecondScreenController {

    public static int openCounter = 0;
    private static Stage stage;
    private static HashMap<String, Parent> screenMap = new HashMap<>();
    private static Scene currentScene;

    public SecondScreenController() {
    }

    public SecondScreenController(Scene currentScene, String name, Parent parent) {
        if(stage == null)
            stage = new Stage();
        stage.setScene(currentScene);
        stage.setResizable(false);
        this.currentScene = currentScene;
        screenMap.put(name, parent);

    }

    public static void addScreen(String name, Parent parent) {
        screenMap.put(name, parent);
    }

    public void activate(String name) throws IOException {
        currentScene.setRoot(screenMap.get(name));
        if (!stage.isShowing())
            stage.show();
    }



}