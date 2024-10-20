// public class PolymorphismOverloading{
//     static class Calculator{
//         int sum ( int a , int b){
//             return a + b;
//         }
//         float sum ( float a , float b){
//             return a + b;
//         }
//         int sum ( int a , int b , int c){
//             return a + b + c;
//         }
//     }
//     public static void main(String args[]){
//         Calculator Calc = new Calculator();
//         System.out.println(Calc.sum(2 , 3));
//         System.out.println(Calc.sum((float)2.3 , (float)3.2));
//         System.out.println(Calc.sum(2 , 3 , 4));
//     }
// }