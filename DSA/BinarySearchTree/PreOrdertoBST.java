package BinarySearchTree;

import java.util.ArrayList;

public class PreOrdertoBST {
    class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

    public BinaryTreeNode<Integer> prorderToBST(ArrayList<Integer> preorder) {
		// Write your code here.
			BinaryTreeNode<Integer> answer = new BinaryTreeNode<Integer>(preorder.get(0));
		for(int i = 1 ; i < preorder.size() ; i++){
			BinaryTreeNode<Integer> root = answer ;
			int val = preorder.get(i);
			BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(val);
			while(true){
				// if(root.left == null && root.right == null){
				// 	if(root.data > val){
				// 		root.left = newNode ;
				// 	}else{
				// 		root.right = newNode ; 
				// 	}
				// 	break ;
				// }
				// if(root.data < val && root.right != null){
				// 	root = root.right ; 
				// }else if(root.left != null){
				// 	root = root.left ;
				// }

				if(root.data > val){
					if(root.left == null){
						root.left = newNode ;
						break;
					}else{
						root = root.left ;
					}
				}
				else{
					if(root.right == null){
						root.right = newNode;
						break ;
					}else{
						root = root.right ;
					}
				}
			}

		}
		return answer ;

	}
}
