public interface Vehicle{
    void start();
    void stop();
}
public interface Car extends Vehicle{
    void honk();
}

public class Honda implements Car{
    @Override
    public void start(){
        System.out.println("Car is starting...");
    }
    @Override
    public void stop(){
        System.out.println("Car is stopping...");
    }
    @Override
    public void honk(){
        System.out.println("Honda i am !!!");
    }
}
public class Bugatti implements Car{
    @Override
    public void start(){
        System.out.println("Car is starting...");
    }
    @Override
    public void stop(){
        System.out.println("Car is stopping...");
    }
    @Override
    public void honk(){
        System.out.println("Vroom Vroom....");
    }
}
public interface VehicleFactory{
    abstract Vehicle getVehicle(String type);
}

public class HondaFactory implements VehicleFactory{
    public void getVehicle(String type){
        if(type.equals("Car")){
            return new Honda() ;
        }
    }

}
public class BugattiFactory implements VehicleFactory{
    public Car getVehicle(String type){
        if(type.equals("Car")){
            return new Bugatti() ;
        }
    }

}





// Easier to extend , just make a new factory 
// Cleaner and more maintainable code 
// Consistency throught the program 

// All products are related to a factory , compiled and relatable 

// USE CASE
// Cross platform UI elements 
// - window UI , MAC Ui , Linux UI
// Database connectione
// - MySql , Oracle , MongoDB , based on configuration you might need various database connections
// Game development 
// family of ojects , different characters , weapons and environment
public class Main{
    public static void main(String[] args){
        HondaFactory hondaFactory = new HondaFactory();
        Car v1 =  hondaFactory.getVehicle("Car");

        v1.start();
        v1.stop();

        BugattiFactory bugattiFactory = new BugattiFactory();
        Car v2 =  bugattiFactory.getVehicle("Car");

        v2.start();
        v2.stop();
    }
}


