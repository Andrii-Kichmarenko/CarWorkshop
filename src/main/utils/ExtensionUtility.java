package utils;

import models.Car;
import models.Client;
import models.Mechanic;

import java.io.*;
import java.util.*;

public abstract class ExtensionUtility implements Serializable {
    private static HashMap<Class<? extends ExtensionUtility>, ArrayList<ExtensionUtility>> extensionMap = new HashMap();

    public ExtensionUtility(){
        Class<? extends ExtensionUtility> instance = this.getClass();

        ArrayList<ExtensionUtility> extension;

        if(extensionMap.containsKey(instance)){
            extension = extensionMap.get(instance);
        }else{
            extension = new ArrayList<>();
            extensionMap.put(instance, extension);
        }
        extension.add(this);
    }

    public static void writeExtension(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extensionMap);
    }

    public static void readExtensionMap(String filePath){
        try
        {
            FileInputStream inFile = new FileInputStream(filePath);
            ObjectInputStream inputStream = new ObjectInputStream(inFile);
            ExtensionUtility.readExtension(inputStream);
            inputStream.close();
            inFile.close();
        }
        catch(IOException i)
        {
            i.printStackTrace();
            return;
        }
        catch(ClassNotFoundException c)
        {
            c.printStackTrace();
            return;
        }
    }

    public static void readExtension(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extensionMap = (HashMap<Class<? extends ExtensionUtility>, ArrayList<ExtensionUtility>>)stream.readObject();
    }

    public static ArrayList getExtension(Class<? extends ExtensionUtility> className){
        return extensionMap.get(className);
    }

    public static void writeExtensionMap(String filePath) {
        try {
            FileOutputStream outFile = new FileOutputStream(filePath);
            ObjectOutputStream outStream = new ObjectOutputStream(outFile);
            ExtensionUtility.writeExtension(outStream);
            outStream.close();
            outFile.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Car getCar(int idCar){
        ArrayList<Car> carsOrigin = getExtension(Car.class);
        Optional<Car> optional =  carsOrigin.stream().filter(car -> car.getIdCar() == idCar).findFirst();
        if(optional.isPresent())
            return optional.get();
        return null;
    }

    public static Mechanic getMechanic(int idMechanic){
        ArrayList<Mechanic> mechanicsOrigin = getExtension(Mechanic.class);
        Optional<Mechanic> optional =  mechanicsOrigin.stream().filter(mechanic -> mechanic.getPerson().getIdPerson() == idMechanic).findFirst();
        if(optional.isPresent())
            return optional.get();
        return null;
    }

    // additional methods
    public static void showExstension(Class<? extends ExtensionUtility> forClass){
        ArrayList<ExtensionUtility> extension;
        if(extensionMap.containsKey(forClass)){
            extension = (ArrayList<ExtensionUtility>) extensionMap.get(forClass);
        }else{
            throw new NoSuchElementException(forClass + " class not found");
        }
        System.out.println("Extension of the class: " + forClass);
        for(ExtensionUtility obj : extension){
            System.out.println(obj);
        }
    }

    public static void showExstensionMap(){
        System.out.println("Extension Map:");
        for(Map.Entry<Class<? extends ExtensionUtility>, ArrayList<ExtensionUtility>> me : extensionMap.entrySet()) {
            System.out.println("\tExtension of the " + me.getKey());
            for (ExtensionUtility obj : me.getValue()) {
                System.out.println(obj);
            }
        }
    }

    public static void getObjectsStatistics(){
        System.out.println("Objects statistics: ");
        for(Map.Entry<Class<? extends ExtensionUtility>, ArrayList<ExtensionUtility>> me : extensionMap.entrySet()) {
            System.out.println("\tNumber of instance " + me.getKey() + ":\t" + me.getValue().size());
        }
    }
}
