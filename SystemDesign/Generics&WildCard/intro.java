static <T> void generateDisplay(T ele){
    System.out.println(ele);
}

class test<T,U>{
    T obj1 ; 
    U obj2 ; 
    public Test(T obj1 , U obj2){
        this.obj1 = obj1 ; 
        this.obj2 = obj2 ; 
    }
}


// Generics allows you to write type safe reusable code by enabling classes , interface and methods to operate on objects of various types 
// type safety 
// -> Code reusability 
// -> No Type 
// -> Casting 


Wrapper classes are used to wrap the primitive data types into objects , so that primitve data types 
can be used with classes and interface that are object specific 
like collection framework , arraylist , HashMap , Set

WildCards are speacial symbols used in generics to represent an unknown type 

<?> unbounded wildCard 
<? extend T> upper bounded wildcard , only read , no write as the datatype is not specified 
<? super T> lower bounded wildcard , you can write

Generics are required when you are adding into collections , 
wildcard dont allow addition as compiler cannot guarantee the type 
public void add(List<?> ls , Object ele){
    ls.add(ele);  // compilation error , can't be sure 
}