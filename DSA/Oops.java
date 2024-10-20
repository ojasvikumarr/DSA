public class Oops{
    public static void main (String[] args){
    //    Vehicle V1 = new Car();
    //    V1.print();
    }
    class Vehicle {
        void print(){
            System.out.println("the is the parent class");
        }
    }
    class Car extends Vehicle{
        void print(){
            System.out.println("this is the child class");
        }
    }
}
