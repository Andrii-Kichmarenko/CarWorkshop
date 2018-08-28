package utils.converters;


import fxmodels.ClientFx;
import models.Client;

public class ConverterClient {

//    public static Book convertToBook(BookFx bookFx){
//        Book book = new Book();
//        book.setIdClient(bookFx.getIdClient());
//        book.setTitle(bookFx.getTitle());
//        book.setDescription(bookFx.getDescription());
//        book.setRating(bookFx.getRating());
//        book.setIsbn(bookFx.getIsbn());
//        book.setReleaseDate(Utils.convertToDate(bookFx.getReleaseDate()));
//        book.setAddedDate(Utils.convertToDate(bookFx.getAddedDate()));
//        return  book;
//    }

    public static ClientFx convertToClientFx(Client client){
        ClientFx clientFx = new ClientFx();
        clientFx.setIdClient(client.getId());
        clientFx.setName(client.getPerson().getName());
        clientFx.setSurname(client.getPerson().getSurname());
        clientFx.setBirthdayDate(client.getPerson().getBirthDate());
        clientFx.setRegistrationDate(client.getRegistrationDate());
        clientFx.setPhoneNumber(client.getPerson().getPhoneNumber());
        clientFx.setEmail(client.getEmailAdress());
        return clientFx;
    }
}
