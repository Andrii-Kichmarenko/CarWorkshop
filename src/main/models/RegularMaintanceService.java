package models;

public class RegularMaintanceService extends Service {

    public RegularMaintanceService() {
        setPrice(250);
        setMechanicCategory(Mechanic.MechanicCategory.FOURTH);
    }
}
