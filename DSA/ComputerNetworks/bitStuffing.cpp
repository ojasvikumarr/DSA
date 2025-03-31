#include <iostream>
#include <vector> 
using namespace std ; 

void bitStuffing(vector<int> data){
    vector<int> stuffed ; 
    int count = 0 ; 
    
    for(int bit : data){

        if(bit == 1){
            count++;
            if(count == 5){
                stuffed.push_back(0);
                count = 0 ; 
            }
        }else{
            count = 0; 
        }
        stuffed.push_back(bit);
    }
    
    cout<<"bit Stuffed Data : " ; 
    for(int bit : stuffed) cout<<bit<<" ";
    cout<<endl ; 
}
int main(){
    vector<int> data = {0 , 1 , 1, 1, 1 ,1 , 1 , 0 , 1,1, 1, 1 , 1, 1 ,1 ,1 ,1 , 0} ;
    bitStuffing(data);
}