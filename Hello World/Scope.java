public class Scope{
    public static void main ( String args[]){
        int p = 1;//p is defined int function scope so it will be working throughout the blocks in the function
        {

            int s = 10;//here the variable 's' is defined in the block scope of the {} so it won't be defined as a variable for the whole function
            System.out.println(p);

        }
        System.out.println(p);
        System.out.println();//it will give error as the variabe 's' is not defined in the function 

    }
}