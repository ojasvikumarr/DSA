#include <stdio.h>
#include <maths.h>
int main(){
    int n ;
     printf("Enter any number whose bin you want!!");
     scanf("%d", &n);
     int lastdigit ;
     int bin ;
     int p =0 ;
     while(n>0){
        lastdigit = n % 2 ;
        bin += (int)(lastdigit*pow(10,p));
        n /= 2 ;
        p++ ;
     }
}