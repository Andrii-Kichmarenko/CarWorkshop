package utils;

import models.Car;
import models.Client;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Filter {

    public static ArrayList<Car> carFilter(ArrayList<Car> carArrayList, Client client){
        ArrayList<Car> resultList = new ArrayList<>();
        carArrayList.forEach(car -> {
            if(car.getClient() == client){
                resultList.add(car);
            }
        });
        return resultList;
    }
}
