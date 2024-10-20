public class Day26 {
    class TreeNode{
        int val ;
        TreeNode left ;
        TreeNode right ;
        public TreeNode(int val){
            this.val = val;
            this.left = this.right = null ;
        }
    }

    public static int Height(TreeNode root){
        if(root == null){
            return 0 ;
        }
        int left = Height(root.left);
        int right = Height(root.right);
        
        return Math.max(left , right)+1 ;
    }
    public static int Diameter(TreeNode root){
        if(root == null){
            return 0 ;
        }
            int leftD = Diameter(root.left);
            int leftH = Height(root.left);
            int rightD = Diameter(root.right);
            int rightH = Height(root.right);

            int currD = leftH + rightH + 1 ;

            return Math.max(leftD , Math.max(rightD , currD));
        
    }
}
