package events;

public class ChooseCarEvent {

    private Integer idCar;

    public ChooseCarEvent(int idCar) {
        this.idCar = idCar;
    }

    public Integer getIdCar() {
        return idCar;
    }
}
