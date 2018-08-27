package models;


public class FullMaintenanceService extends Service{

    public FullMaintenanceService() {
        setTimePeriod(6);
        setDistancePeriod(10000);
        setMechanicCategory(Mechanic.MechanicCategory.SECOND);
        setPrice(400);
    }
}
