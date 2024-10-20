public class constructor {
    public static void main(String args[]){
       // Student s1 = new Student("Ojasvi");
       // System.out.println(s1.name);
        // Student s1 = new Student();
    }

    class Student {
        String name;
        int roll;

        /*Student(String name){
            this.name=name;
        }*/
        Student (){
            System.out.println("COnstructor is called....");
        }
    }
}