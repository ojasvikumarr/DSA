// Online C++ compiler to run C++ program online
#include <iostream>
#include <vector>
using namespace std ; 
#define ESC 'E'
#define FLAG 'F'
void byteStuffing(vector<char> data){
    vector<char> stuffed; 
    for(char byte : data){
        if(byte == FLAG || byte == ESC){
            stuffed.push_back('e');
        }
        stuffed.push_back(byte);
    }
    
    for(char byte : stuffed){
        cout<<byte<<" " ;
    }
    cout<<endl ;
}
int main() {
    // Write C++ code here
    vector<char> data = {'A' , 'B' , 'C' , 'D' , 'E' , 'F'} ;
    byteStuffing(data);
    
    return 0;
}