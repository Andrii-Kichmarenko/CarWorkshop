package fxml;

import controllers.ScreenController;
import controllers.SecondScreenController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.DataCreater;
import utils.ExtensionUtility;

import java.io.File;

public class Main extends Application {

    private static String pathToExtensionMap = "extensionMap.txt";
    private static String pathToParent = "orders_view.fxml";
    private static String pathToParent1 = "choose_client_view.fxml";
    private static String pathToParent2 = "choose_car_view.fxml";
    private static String pathToParent3 = "choose_mechanic_view.fxml";
    private static String pathToParent4 = "add_car_form_view.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent parent = FXMLLoader.load(getClass().getResource(pathToParent));
        Parent parent1 = FXMLLoader.load(getClass().getResource(pathToParent1));
        Parent parent2 = FXMLLoader.load(getClass().getResource(pathToParent2));
        Parent parent3 = FXMLLoader.load(getClass().getResource(pathToParent3));
        Parent parent4 = FXMLLoader.load(getClass().getResource(pathToParent4));
        primaryStage.setTitle("Car Workshop");

        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        ScreenController screenController = new ScreenController(scene, "orders_view" , parent);
        screenController.addScreen("choose_client_view", parent1);
        screenController.addScreen("choose_car_view", parent2);
        screenController.addScreen("choose_mechanic_view", parent3);
        primaryStage.setScene(scene);
        primaryStage.show();
        screenController.setMinWidthHeight();

        Scene scene1 = new Scene(parent4);
        SecondScreenController secondScreenController = new SecondScreenController(scene1,"add_car_form_view", parent4);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                saveAndFinish();
            }
        }));

    }

    public static void main(String[] args) throws Exception {

        if (new File(pathToExtensionMap).isFile()) {
            ExtensionUtility.readExtensionMap(pathToExtensionMap);
        }else{
            DataCreater.createData();
        }

        launch(args);
    }

    public static void saveAndFinish(){
        ExtensionUtility.writeExtensionMap(pathToExtensionMap);
        Platform.exit();
    }
}
