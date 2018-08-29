package events;

public class ChooseClientEvent {

    private Integer idClient;

    public ChooseClientEvent(int idClient) {
        this.idClient = idClient;
    }

    public Integer getIdClient() {
        return idClient;
    }
}
