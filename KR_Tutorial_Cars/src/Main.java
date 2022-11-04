import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        MyCollections<Automobile> cars = new MyCollections<>();
        File fileCars = new File("src\\cars.txt");
        try {
            readCars(fileCars,cars);
            cars.printContainer();
            Car a = new Car("lifan","gray",Fuel.DIZEL,Material.COTTON);
            System.out.println("Frequency is: " + cars.amount(a));
            System.out.println("Max is " + cars.max());
            Car a1 = (Car) cars.binarySearch(a);
            if(a1 == null)
               System.out.println("No such car!");
            else System.out.println("Car was founded!");
        }
        catch (IOException e)
        {
            System.out.println("Error!");
        }
        catch (EmptyException e)
        {
            System.out.println("Error1!");
        }
    }
    public static void readCars(File f, MyCollections cars) throws FileNotFoundException, IOException,EmptyException
    {
        Scanner s = new Scanner(f);
        String name,color,material,fuel;
        Fuel fuel1 = Fuel.BENZIN;
        Material material1 = Material.COTTON;
        while (s.hasNext())
        {
            name = s.next();
            color = s.next();
            fuel = s.next();
            fuel1 = fuel1.toType(fuel);
            material = s.next();
            material1 = material1.toType(material);
            cars.add(new Car(name,color,fuel1,material1));
        }
        System.out.println("Cars were read!");
    }
}