package controllers;

import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        setMinWidthHeight();
    }

    public void setMinWidthHeight(){
        Node root = currentScene.getRoot();
        Bounds rootBounds = root.getBoundsInLocal();
        double deltaW = currentScene.getWindow().getWidth() - rootBounds.getWidth();
        double deltaH = currentScene.getWindow().getHeight() - rootBounds.getHeight();

        Bounds prefBounds = getPrefBounds(root);

        ((Stage)currentScene.getWindow()).setMinWidth(prefBounds.getWidth() + deltaW);
        ((Stage)currentScene.getWindow()).setMinHeight(prefBounds.getHeight() + deltaH);
    }

    private Bounds getPrefBounds(Node node) {
        double prefWidth ;
        double prefHeight ;

        Orientation bias = node.getContentBias();
        if (bias == Orientation.HORIZONTAL) {
            prefWidth = node.prefWidth(-1);
            prefHeight = node.prefHeight(prefWidth);
        } else if (bias == Orientation.VERTICAL) {
            prefHeight = node.prefHeight(-1);
            prefWidth = node.prefWidth(prefHeight);
        } else {
            prefWidth = node.prefWidth(-1);
            prefHeight = node.prefHeight(-1);
        }
        return new BoundingBox(0, 0, prefWidth, prefHeight);
    }

}
