package utils.converters;


import fxmodels.ClientFx;
import models.Client;

public class ClientConverter {

    public static ClientFx convertToClientFx(Client client){
        ClientFx clientFx = new ClientFx();
        clientFx.setIdClient(client.getPerson().getIdPerson());
        clientFx.setName(client.getPerson().getName());
        clientFx.setSurname(client.getPerson().getSurname());
        clientFx.setBirthdayDate(client.getPerson().getBirthDate());
        clientFx.setRegistrationDate(client.getRegistrationDate());
        clientFx.setPhoneNumber(client.getPerson().getPhoneNumber());
        clientFx.setEmail(client.getEmailAdress());
        return clientFx;
    }
}
