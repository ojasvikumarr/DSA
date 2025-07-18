public interface Vehicle{
    void start();
    void stop();
}

public class Car implements Vehicle{
    public void start(){
        System.out.println("Car is Starting...");
    }
    public void stop(){
        System.out.println("Car is Stopping...");
    }
}
class Bike implements Vehicle{
    public void start(){
        System.out.println("Bike is Starting...");
    }
    public void stop(){
        System.out.println("Bike is Stopping...");
    }
}
class Truck implements Vehicle{
    public void start(){
        System.out.println("Truck is Starting...");
    }
    public void stop(){
        System.out.println("Truck is Stopping...");
    }
}

public class VehicleFactory{
    public static Vehicle getVehicle(String type){
        if(type.equals("Car")){
            return new Car();
        }else if(type.equals("Bike")){
            return new Bike();
        }else if(type.equals("Truck")){
            return new Truck();
        }
        return new Car();
    }
}

public class Main{
    public static void main(String[] args){
        Vehicle v1 = vehicleFactory.getVehicle("Car");

    }
}