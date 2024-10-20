public class Abstract{
    abstract class Animals{
        void eats(){
            System.out.println("animals eats food");
        }

        abstract void walk();
        
    } 
    class Horse extends Animals{
        void walk(){
            System.out.println("walks on 4 legs");
        }
    }
    class Pig extends Animals{
        void walk(){
            System.out.println("walks of 10 legs");
        }
    }
    
    public static void main (String args[]){
    //     Horse h= new Horse();
    //     h.eats();
    //     h.walk();

    //     Pig p = new Pig();
    //     p.eats();
    //     p.walk();
    }
    
    
}