public class Car{
    private String engine;
    private int wheels; 
    private int seats; 
    private String color;
    private boolean sunRoof;

    private Car(CarBuilder builder){
        this.engine = builder.engine ; 
        this.wheels = builder.wheels ; 
        this.seats = builder.seats ; 
        this.color = builder.color ; 
        this.sunRoof = builder.sunRoof ; 
    }

    // Getters to perform on Car object
    public String getEngine(){
        return this.engine ; 
    }
    public String getColor(){
        return this.color ;
    }
    public int getWheels(){
        return this.wheels ; 
    }
    public int getSeats(){
        return this.seats ; 
    }
    public boolean getSunRoof(){
        return this.sunRoof ; 
    }



    public static class CarBuilder{
        private String engine ;
        private int wheels = 4 ; 
        private int seats = 5 ; 
        private String color = "White";
        private boolean sunRoof = false ;

        // Setters 
        public CarBuilder setEnginer(String engine){
            this.engine = engine ; 
            return engine ;
        }

        public CarBuilder setWheels(String wheels){
            this.wheels = wheels ; 
            return this ;
        }

        public CarBuilder setSeats(int seats){
            this.seats = seats ; 
            return this ;
        }

        public CarBuilder setColor(String color){
            this.color = color ; 
            return this; 
        }

        public CarBuilder setSunRoof(boolean sunRoof){
            this.sunRoof = sunRoof ;
            return this ; 
        }

        //constructor 
        public Car build(){
            return new Car(this);
        }
    }

}

public static class Main{
    public static void main(String[] args){
        //because it was set as static , so we can call directly by name
        Car.CarBuilder builder = new Car.CarBuilder() ;

        Car car1 = builder.setEngine("V8")
                        .setWheels("4")
                        .setSeats(5)
                        .setColor("Red")
                        .setSunRoof(true)
                        .build() ;

        Car car2 = builder.setEngine("V12")
                        .setWheels("4")
                        .setSeats(2)
                        .setColor("Blue")
                        .setSunRoof(false)
                        .build() ;
    }
}