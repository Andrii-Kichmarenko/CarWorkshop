package fxmodels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import models.Client;
import org.omg.CORBA.portable.ApplicationException;
import utils.ExtensionUtility;
import utils.converters.ClientConverter;

import java.util.ArrayList;
import java.util.List;

public class ListClientsModel {

    private ObservableList<ClientFx> clientFxObservableList = FXCollections.observableArrayList();
    private List<ClientFx> clientFxList = new ArrayList<>();

    public void init() throws ApplicationException {
        Class instance = Client.class;
        List<Client> clients = ExtensionUtility.getExtension(instance);
        if(clients != null){
            clients.forEach(client -> {
                this.clientFxList.add(ClientConverter.convertToClientFx(client));
            });
            this.clientFxObservableList.setAll(clientFxList);
        }
    }

    public ObservableList<ClientFx> getClientFxObservableList() {
        return clientFxObservableList;
    }

}