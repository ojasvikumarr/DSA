public class Constructor2{
    // public static void main (String args[]){
    //     Student S1 = new Student();
    //     Student S2 = new Student("ojasvi");
    //     Student S3 = new Student("63");
    //     //Student S4 = new Student("OJasvi",63);   not made a constructor like this thus not valid
    //     Student S = new Student();
    //     S.name = "Ojasvi";
    //     S.rollno = 89;
    //     S.Password = "OjasK";
    //     Student S4 = new Student(S);
    //     S4.password = "hello";
    // }

    class Student{
        String name ;
        int rollno;
        String Password;
        Student(){
            System.out.println("my name is Ojasvi");
        }

        Student(String name){
            this.name=name;
        }

        Student(int rollno){
            this.rollno = rollno;
        }

        Student (Student S){
            this.name = S.name;
            this.rollno = S.rollno;

        }
    }
}