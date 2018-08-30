package fxmodels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Client;
import models.Mechanic;
import org.omg.CORBA.portable.ApplicationException;
import utils.ExtensionUtility;
import utils.converters.ClientConverter;
import utils.converters.MechanicConverter;

import java.util.ArrayList;
import java.util.List;

public class ListMechanicsModel {

    private ObservableList<MechanicFx> mechanicsFxObservableList = FXCollections.observableArrayList();
    private List<MechanicFx> mechanicsFxList = new ArrayList<>();

    public void init() throws ApplicationException {
        Class instance = Mechanic.class;
        List<Mechanic> mechanics = ExtensionUtility.getExtension(instance);
        if(mechanics != null){
            mechanics.forEach(mechanic -> {
                this.mechanicsFxList.add(MechanicConverter.convertToMechanicFx(mechanic));
            });
            this.mechanicsFxObservableList.setAll(mechanicsFxList);
        }
    }

    public ObservableList<MechanicFx> getMechanicsFxObservableList() {
        return mechanicsFxObservableList;
    }

}
