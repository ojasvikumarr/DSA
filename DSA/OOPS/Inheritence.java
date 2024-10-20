public class Inheritence {
    public static void main (String args[]){
        // Fish SHark = new Fish();
        // SHark.eat();
    }
    class Animals{
        String color;
        void eat (){
            System.out.println("eats");
        }
        void breath(){
            System.out.println("breathes");
        }
    }
//Derived class or Subclass
    class Fish extends Animals{
        int fins;
        void swim (){
            System.out.println("FIsh swims in water!!");
        }
    }
//multilevel inheritence
    class Mammals extends Fish{
        int legs;
    }

    class bird extends Animals{
        int wings;
    }
//Hybrid Inheritence

}
