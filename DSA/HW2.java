public class HW2 {
    public static void MergeSort(String str[], int si , int ei ){
        //kaam
        int mid = si + ( ei - si )/2 ;
        MergeSort(str, si, mid);
        MergeSort(str, mid+1, ei);
        merge(str, si, ei);
    }

    public static void merge(String str[] , int si , int ei ){
        String temp[] = new String[ei - si +1];
        int mid = si +(ei - si)/2;
        int i = si ; //iterator for left part
        int j = mid +1 ; //iterator for right part
        int k = 0 ;
        while(i <=mid && j <= ei){
            // if( str[i] < str[j]){
            //     temp[k] = str[i];
            // }
            // else{
            //     temp[k] = str[j];
            // }
            k++;
        }

        while(i<= mid ){
            temp[k++]= str[i++];
        }
        while (j <= ei) {
            temp[k++] = str[j++];
        }
        // for(k = 0 , i = si ; k <String.length[] ; k++ ,i++){
        //     str[i] = temp[k] ;
        // }
    }
    public static void main ( String args[]){

    }
}
