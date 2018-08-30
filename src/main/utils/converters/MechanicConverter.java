package utils.converters;

import fxmodels.ClientFx;
import fxmodels.MechanicFx;
import models.Client;
import models.Mechanic;

public class MechanicConverter {

    public static MechanicFx convertToMechanicFx(Mechanic mechanic){
        MechanicFx mechanicFx = new MechanicFx();
        mechanicFx.setIdMechanic(mechanic.getPerson().getIdPerson());
        mechanicFx.setName(mechanic.getPerson().getName());
        mechanicFx.setSurname(mechanic.getPerson().getSurname());
        mechanicFx.setPhoneNumber(mechanic.getPerson().getPhoneNumber());
        mechanicFx.setCategory(mechanic.getCategory());
        return mechanicFx;
    }
}
