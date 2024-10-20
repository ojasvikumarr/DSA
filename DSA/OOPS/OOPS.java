// public class OOPS{
//  //keyword:public | access specifier:static | return type:void
//  //bye convention main function needs to be public and static thats why we neeed to type them here and we didnt use it below where there is pen 
//     public static void main (String args[]){
//         Pen p1 = new Pen() ; //by this we have created a pen object claled p1
//         //these objects are made in the heap storage of java 
//         p1.Setcolor("blue"); //.(dot)operator is used to call the function 
//         System.out.println(p1.color);
//         p1.color = "yellow";
//         System.out.println(p1.color);

//         BankAccounts B1 = new BankAccounts();
//         //B1.username("ojasvi");
//         //B1.password("helloworld");//this will show erroe as the password function is made private that will eventually not let anyone access the passwrod from outside the class
//         B1.SetPass("ojasvi");
//     }
// }

// //this is the blueprint of the pen 
// class Pen{
//     String color ;
//     int tip;
// //getters
//     //'this' its is a operator that specifies that we are talking about the specified word or the variable that is considered to be modified
//     //for example see the setters where there is....
//     String getcolor(){
//         return this.color;
//     }
//     int getTip(){
//         return this.tip;
//     }
// //Setters
//     //here we used the name of the new variable same as that of the pen but the it recogonizes it as the pen varibale then also
//     void Setcolor(String color){
//         this.color = color;
//     }
//     //this operator tells that the 'this.tip' is the property of the pen while the tip is an external varibale
//     void SetTip(int newTip){
//         tip=newTip;
//     }
//     //this is used when there is too many variables having same name
// }

// //this class is made to understand the concept of access modifiers

// // class BankAccounts{
// //     public String username;
// //     private String password;
// //     //this will help us to enter or give the password to the class but we wont be able to access the password or display it 
// //     public void SetPass ( String newPWD){
// //         password = newPWD;
// //     }
// // }