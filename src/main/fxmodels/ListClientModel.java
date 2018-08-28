package fxmodels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import models.Client;
import org.greenrobot.eventbus.EventBus;
import org.omg.CORBA.portable.ApplicationException;
import utils.ExtensionUtility;
import utils.converters.ConverterClient;

import java.util.ArrayList;
import java.util.List;

public class ListClientModel {
    private ObservableList<ClientFx> clientFxObservableList = FXCollections.observableArrayList();
//    private ObservableList<AuthorFx> authorFxObservableList = FXCollections.observableArrayList();
//    private ObservableList<CategoryFx> categoryFxObservableList = FXCollections.observableArrayList();
//
//    private ObjectProperty<AuthorFx> authorFxObjectProperty = new SimpleObjectProperty<>();
//    private ObjectProperty<CategoryFx> categoryFxObjectProperty = new SimpleObjectProperty<>();

    private List<ClientFx> clientFxList = new ArrayList<>();

    public void init() throws ApplicationException {
        Class instance = Client.class;
        List<Client> clients = ExtensionUtility.getExtension(instance);
        clientFxList.clear();
        clients.forEach(client -> {
            this.clientFxList.add(ConverterClient.convertToClientFx(client));
        });
        this.clientFxObservableList.setAll(clientFxList);

 //       initAuthors();
 //       initCategory();
    }

    public ObservableList<ClientFx> getClientFxObservableList() {
        return clientFxObservableList;
    }

    public void setBookFxObservableList(ObservableList<ClientFx> clientFxObservableList) {
        this.clientFxObservableList = clientFxObservableList;
    }
}