package events;

public class ChooseMechanicEvent {

    private Integer idMechanic;

    public ChooseMechanicEvent(Integer idMechanic) {
        this.idMechanic = idMechanic;
    }

    public Integer getIdMechanic() {
        return idMechanic;
    }
}
