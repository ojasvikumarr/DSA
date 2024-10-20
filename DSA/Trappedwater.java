public class Trappedwater{
    public static int Trapped_Rainwater(int n[]){
        //calculate left max boundry-array
        int leftMax[]=new int[n.length];
        leftMax[0]=n[0];
        for(int i = 1 ; i<n.length ; i++){
            leftMax[i]=Math.max(n[i],leftMax[i-1]);
        }

        //calculate rightmax boundry-array
        int rightMax[] = new int [n.length];
        rightMax[n.length-1]=n[n.length-1];
        for ( int i = n.length-2 ; i >= 0 ; i--){
            rightMax[i] = Math.max(n[i],rightMax[i+1]);
        }
        //loop
        int Trappedwater = 0 ;
        for( int i = 0 ; i<n.length  ;i++){
            //waterlevel = MIN(leftmax , rightmax)
            int waterlevel = Math.min(leftMax[i],rightMax[i]);
            //trapped water = waterlevel - height[i]
            Trappedwater += waterlevel-n[i];
        }
    return Trappedwater;
        
    }
    public static void main ( String args [ ] ){
        int numbers[] = {4,2,0,6,3,2,5};
        System.out.println(Trapped_Rainwater(numbers));
    
    }
}