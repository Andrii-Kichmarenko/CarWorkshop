package events;

import models.Client;

public class ChooseClientEvent {

    private Client client;

    public ChooseClientEvent(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }
}
