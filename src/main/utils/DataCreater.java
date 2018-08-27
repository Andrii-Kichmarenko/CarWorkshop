package utils;

import models.Car;
import models.Client;
import models.Person;

import java.time.LocalDate;
import java.time.Month;

public class DataCreater {

    public static void createData() throws Exception {

        Person person1 = new Person("Andrii", "Kichmarenko", LocalDate.of(1995, Month.of(10), 30));
        Client client1 = Client.createClient(person1, LocalDate.now() );
        client1.setEmailAdress("kichmarenko.a@gmail.com");
        person1.setPhoneNumber("737733855");

        Person person2 = new Person("Jan", "Kowalski", LocalDate.of(1985, Month.of(6), 20));
        Client client2 = Client.createClient(person2, LocalDate.now() );
        client2.setEmailAdress("Kowalski.knopp@gmail.com");

        Car car1 = new Car("11111111111111111", "Mercedes", "E", 2.2, LocalDate.of(2017, Month.of(6), 20));
        client1.addCar(car1);

/*        Category category1 = new Category();
        category1.setName("Dramat");
        Author author1 = new Author();
        author1.setName("William");
        author1.setSurname("Szekspir");
        Book book1 = new Book();
        book1.setCategory(category1);
        book1.setAuthor(author1);
        book1.setTitle("Makbet");
        book1.setIsbn("8386740418l");
        book1.setRating(4);
        book1.setReleaseDate(new Date());
        book1.setAddedDate(new Date());
        book1.setDescription("Byłaby to fajna książka, gdyby nie była lekturą");


        Category category2 = new Category();
        category2.setName("Sensacja");
        CategoryDao categoryDao = new CategoryDao();
        try {
            categoryDao.creatOrUpdate(category2);
            DbManager.closeConnectionSource();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }


        Category category3 = new Category();
        category3.setName("Reportaż");
        Author author2 = new Author();
        author2.setName("Mariusz");
        author2.setSurname("Szczygieł");
        Book book2 = new Book();
        book2.setCategory(category3);
        book2.setAuthor(author2);
        book2.setTitle("Gottland");
        book2.setIsbn("8386740418l");
        book2.setRating(5);
        book2.setReleaseDate(new Date());
        book2.setAddedDate(new Date());
        book2.setDescription("Ciekawe reportaże, ze świata");

        Category category4 = new Category();
        category4.setName("Fantastyka");
        Author author3 = new Author();
        author3.setName("John Ronald Reuel");
        author3.setSurname("Tolkien");
        Book book3 = new Book();
        book3.setCategory(category4);
        book3.setAuthor(author3);
        book3.setTitle("Władca Pierścieni");
        book3.setIsbn("8386740418l");
        book3.setRating(5);
        book3.setReleaseDate(new Date());
        book3.setAddedDate(new Date());
        book3.setDescription("O dwóch takich, co nieśli pierścień");

        Author author4 = new Author();
        author4.setName("Terry ");
        author4.setSurname("Pratchett");
        Book book4 = new Book();
        book4.setCategory(category4);
        book4.setAuthor(author4);
        book4.setTitle("Kolor magii");
        book4.setIsbn("8386740418l");
        book4.setRating(3);
        book4.setReleaseDate(new Date());
        book4.setAddedDate(new Date());
        book4.setDescription("Do przeczytania");

        BookDao bookDao = new BookDao();
        try {
            bookDao.creatOrUpdate(book1);
            bookDao.creatOrUpdate(book2);
            bookDao.creatOrUpdate(book3);
            bookDao.creatOrUpdate(book4);
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
        DbManager.closeConnectionSource();
 */
    }
}
