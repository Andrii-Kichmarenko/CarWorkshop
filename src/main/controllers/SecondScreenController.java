package controllers;

import events.OpenAddCarEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.HashMap;

public class SecondScreenController {

    private Stage stage;
    private static HashMap<String, Parent> screenMap = new HashMap<>();
    private static Scene currentScene;

    public SecondScreenController() {
    }

    public SecondScreenController(Scene currentScene, String name, Parent parent) {
        stage = new Stage();
        stage.setScene(currentScene);
        this.currentScene = currentScene;
        screenMap.put(name, parent);
        EventBus.getDefault().register(this);
    }

    public static void addScreen(String name, Parent parent) {
        screenMap.put(name, parent);
    }

    public void activate(String name) throws IOException {
        currentScene.setRoot(screenMap.get(name));
        if (!stage.isShowing())
            stage.show();
    }

    @Subscribe
    public void onOpenAddCarEvent(OpenAddCarEvent event) {
        try {
            activate("add_car_form_view");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}