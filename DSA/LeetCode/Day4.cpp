
#include <iostream>
#include <cstdlib> //for rand() function
class Node {
    public: 
    int data ;
    Node* next ;
    Node(int data){
        this->data = data ;
        next = NULL ;
    }
}
class RandomizedSet {
private:
Node* head ;
public:
    RandomizedSet() {
        head = NULL ;
    }
    
    bool insert(int val) {
        if(head == NULL){
            head = new Node(val);
            return true ;
        }
        Node* temp = head ;
        while(temp-> next != NULL){
            if(temp.data == val){
                return false ;
            }
            temp = temp->next ;
        }
        temp->next = new Node(val);
        return true ;
    }
    
    bool remove(int val) {
        if(head == NULL){
            return false ;
        }
        if(head->val == val){
            head = head->next ;
            return true ;
        }
        Node* temp = head ;
        while(temp->next != NULL){
            if(temp->next->data == val){
                Node* rem = temp->next ;
                temp->next = temp->next->next ;
                free(rem);
                return true ;
            }
            temp = temp->next ;
        }
        return false ;
    }
    
    int getRandom() {
        int result = head->data ;
        Node* current = head ;
        int count = 1 ;

        while(current->next != NULL){
            if(rand() % count == 0){
                result = current->data ;
            }
            count++ ;
            current = current->next ;
        }
        return result ;
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */