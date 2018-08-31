package utils;

import models.*;

import java.time.LocalDate;
import java.time.Month;

public class DataCreater {

    public static void createData() throws Exception {

        //People
        Person person1 = new Person("Andrii", "Kichmarenko", LocalDate.of(1995, Month.of(10), 30));
        person1.setPhoneNumber("737733855");
        Client client1 = Client.createClient(person1, LocalDate.now() );
        client1.setEmailAdress("kichmarenko.a@gmail.com");

        Person person2 = new Person("Jan", "Kowalski", LocalDate.of(1985, Month.of(6), 20));
        Client client2 = Client.createClient(person2, LocalDate.now() );
        client2.setEmailAdress("Kowalski.knopp@gmail.com");

        Person person3 = new Person("Oleksandr", "Pupok", LocalDate.of(1992, Month.of(6), 15));
        person3.setPhoneNumber("666888999");
        Mechanic mechanic1 = Mechanic.createMechanic(person3, LocalDate.of(2018, Month.of(6), 30), Mechanic.MechanicCategory.THIRD, 500);
        Person person4 = new Person("Michał", "Jakubowić", LocalDate.of(1980, Month.of(3), 19));
        Mechanic mechanic2 = Mechanic.createMechanic(person4, LocalDate.of(2016, Month.of(10), 01), Mechanic.MechanicCategory.FIRST, 1500);
        Person person5 = new Person("Ostap", "Wysznia", LocalDate.of(1975, Month.of(8), 5));
        Mechanic mechanic3 = Mechanic.createMechanic(person5, LocalDate.of(2017, Month.of(3), 11), Mechanic.MechanicCategory.FIRST, 1400);
        //mechanic client
        Client client3 = Client.createClient(person3, LocalDate.now());

        //vehicles
        Car car1 = new Car("11111111111111111", "Mercedes", "E", 2.2, LocalDate.of(2017, Month.of(6), 20));
        client1.addCar(car1);
        Car car2 = new Car("22222222222222222", "Renault", "Clio", 1.2, LocalDate.of(2014, Month.of(5), 10));
        client1.addCar(car2);
        Car car3 = new Car("33333333333333333", "Volvo", "V70", 2.5, LocalDate.of(2006, Month.of(3), 26));
        client2.addCar(car3);

        // orders
        Order order = new Order(LocalDate.now());
        order.setCar(car3);
        order.setMechanic(mechanic2);

    }
}
