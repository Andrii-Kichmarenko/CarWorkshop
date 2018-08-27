package models;

public class InterimMaintenceService extends Service {

    public InterimMaintenceService() {
        setTimePeriod(6);
        setDistancePeriod(10000);
        setMechanicCategory(Mechanic.MechanicCategory.FOURTH);
        setPrice(200);
    }
}
