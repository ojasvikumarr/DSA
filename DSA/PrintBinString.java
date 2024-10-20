

public class PrintBinString {
//This was giving wronfg answer as StringBuilder made it complex 
    public static void Printbinstring(int n, int Lastplace , StringBuilder str ){
        //base value

        if( n == 0 ){
            System.out.println(str);
            return;
        }
/*         if ( Lastplace == 0 ){
            Printbinstring(n-1, 0 , str.append("0"));
            Printbinstring(n-1, 0 , str.append("1"));
        }
        else{
            Printbinstring(n-1, 0 , str.append("0"));
        }
*/     

//we needed to remove the value 0 or 1 once the were placed thats why it gave wrong value
        Printbinstring(n-1, 0 , str.append("0"));
        if(Lastplace == 0){
            Printbinstring(n-1, 1 , str.append("1"));
        }
    }

    public static void Printbinstring2(int n, int Lastplace, String str) {
        // base value

        if (n == 0) {
            System.out.println(str);
            return;
        }
        /*
         * if ( Lastplace == 0 ){
         * Printbinstring(n-1, 0 , str.append("0"));
         * Printbinstring(n-1, 0 , str.append("1"));
         * }
         * else{
         * Printbinstring(n-1, 0 , str.append("0"));
         * }
         */
        Printbinstring2(n - 1, 0, str+"0");
        if (Lastplace == 0) {
            Printbinstring2(n - 1, 1, str+"1");
        }
    }

    public static void main ( String args[]){
        Printbinstring2(3, 0, "");
    }
}
