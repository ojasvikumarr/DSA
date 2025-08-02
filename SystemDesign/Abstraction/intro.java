public class intro{
    // Abstraction 
    // it is a core concept of object oriented programming 
    // which focues on exposing only the essential implementation of the object while
    // hidding the its undeerlying complexity and implementationd details 


    // in java abstraction is donw using abstract classes and interfaces 

    public abstract class Vehicle{
        // acts as a blueprint for other classes , providing 
        // foundation of shared behaviour , while allowing subclasses to implement specific behvaiour 

        // it can have abstaract methods , whihc are only to be defined but not implemented
        abstract void display() ;// abstract method for specific behaviour 
        void sleep(){// concrete method for shared behaviour
            System.out.println("Sleeping");
        }
    }
    public class Car extends Vehicle{
        // Mehtod Overriding , done at runtime , therefore runtime Polymorphism 
        // same operation does different behaviour based on the subclass
        @Override 
        void display(){
            System.out.println("I am a car");
        }
    }

    // Code maintainability increases , subclass can implement specification 
    // classes with same behaviour are linked together , better code structure 
    // changes in shared behaviour needs to be done only at one place 

    // When the classes are not structured correctly then confusion , redundant code , implementation overhead 





    Interfaces 
    
    a contract for behaviour , the classes that implements this interface must follow a set of rules that class must follow 
    it has abstract methods, 
    java 8 update , allows to have default and static methods 

    Advantages of Interface : 
    - Decoupling : separating the declaration of methods from their implementation
    - Standardisation : if i want all classes to make sound , i will be able to do that 

    Disadvantages of Interface : 
    - COmplexity increases
    - Overhead in Maintenance (You need to trac you way up the heirarchy)


    Abstract classes can contain : 
    abstract methods and concrete method
    varaibles that are static , non static , final , non final 

    All the methods in the interface are abstract by default , 
    and the implementing class must implement all the methods 
    java 8 - default and static 
    java 9 - private methods 



    public abstract class Vehicle{
        abstract void display();
        public void sleep(){
            System.out.println("Sleeping");
        }
    }

    public interface class Car{
        abstract void display();
        abstract void sleep();
    }

    abstract class Animal{
        String name ; 
        abstract void sound();
        Animal(String s){
            this.name = s ;
        }
    }
    class Dog extends Animal{
        Day(String s){
            super(s);
        }
        @Override 
        void sound(){
            System.out.println("Bark");
        }
    }


    // Access Modifiers 
    // public 
    // protected
    // Default 
    // private 

    // Association 
    --> One class uses other class 
    // Aggregation (Has-a)
    --> A weak form of association , other class is not depeendent on any other class 
    like depatrments have many professors but if department does not exists, professors still exists
    // Composition 
    --> child cannot exist without parent , child inherits parent class all the methods and variable 
    // Dependency 
    --> A class temporarily uses other class objects 
    

}