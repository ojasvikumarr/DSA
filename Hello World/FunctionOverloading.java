public class FunctionOverloading{
    public static int sum(int a, int b ){
        return a+b;
    }
    public static int sum(int a, int b, int c ){
        return a+b;
    }
    public static int sum(int a, int b, int c, int d ){
        return a+b+c+d;
    }
    public static float sum(float a, float b ){
        return a+b;
    }
    public static double sum(double a, double b ){
        return a+b;
    }

    public static void main (String args[]){
        System.out.println(sum(10,10.23));
    }
    
}