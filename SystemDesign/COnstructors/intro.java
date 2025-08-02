// default constructor
public class intro{
    public class Node{
        int src ; 
        Node next ; 
        public void solve(){
            System.out.println("Solving..");
        }
    }

    //parameterized constructor
    public class Car{
        int model ; 
        String name; 
        public Car(){
            model = 100 ; 
            name = "#";
        }
        public Car(int model , String name){
            this.model = model ; 
            this.name = name ; 
        }
    }

    //Copy Constructor 
    public class Bike{
        int model 
        String name ; 
        public Biker(Bike b){
            this.model = b.model ; 
            this.name = b.name ;
        }
    }

    //Private Constructor 
    public class Logger{
        Logger instance ; 
        private Logger(){
            this.instance = new Logger();
        }
        public static Logger getLogger(){
            synchronized(Logger.class){

            }
            if(instance == null){
                return new Logger();
            }
            return instance ; 
        }
    }

    //Constructor Chaining
    // overusing This keyword can reduce the readability and clarity of the code 
    public class Truck{
        int model ; 
        String name ; 

        // THis will give compilation error , as this keyword cannot be used in static methods
        public static getTruckInfo(){
            System.out.println("Model is : "+this.model+" Name is : "+this.name);
        }

        public Truck(){
            return this(111 , "###");
        }
        public Truck(int n , String s){
            this.model = n ; 
            this.name = s ;
        }

        public Truck setName(String n){
            this.name = n ; 
            return this ;
        }
        public void display(){
            System.out.println("Model is : "+this.model+" Name is : "+this.name);
        }
    }

    public static void main(String[] args){
     ¸  Node n = new Node(); // this is default constructor being called 
        n.solve();

        Car c = new Car();
        Car cc = new Car(100 , "Honda");

    }
}