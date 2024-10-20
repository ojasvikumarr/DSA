import java.util.ArrayList;
public class DArrayList {
    public static void main (String args[]){
        ArrayList<ArrayList<Integer>> Mainlist = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);list.add(10);list.add(28);
        Mainlist.add(list);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(13);list2.add(101);list2.add(228);
        Mainlist.add(list2);
        for(int i = 0 ;i<Mainlist.size() ; i++){
            ArrayList<Integer> currList = Mainlist.get(i) ;
            for( int j = 0 ; j<currList.size() ; j++){
                System.out.print(currList.get(j)+" : " );
            }
            System.out.println();
        }

        System.out.println(Mainlist);

        ArrayList<Integer> lisst1 = new ArrayList<>();
        ArrayList<Integer> lisst2 = new ArrayList<>();
        ArrayList<Integer> lisst3 = new ArrayList<>();
        for( int i = 1 ; i < 6 ; i++){
            lisst1.add(i*1);
            lisst2.add(i*2);
            lisst3.add(i*3);
        }
        System.out.println(lisst1);
        System.out.println(lisst2);
        System.out.println(lisst3);
        Mainlist.add(lisst1);
        Mainlist.add(lisst2);
        Mainlist.add(lisst3);
        lisst1.remove(2);
        lisst2.remove(3);
        System.out.print(Mainlist);

        for( int k = 0; k< Mainlist.size() ; k++ ){
            ArrayList<Integer> currLists = Mainlist.get(k);
            for( int l= 0 ; l< currLists.size() ; l++){
                System.out.print(currLists.get(l));
            }
            System.out.println();
        }
    }
}
