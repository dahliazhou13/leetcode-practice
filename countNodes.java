/**
 * Description: Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, 
is completely filled in a complete binary tree, 
and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.
 */
class Solution {
    public int countNodes(TreeNode root) {
        
        if(root == null) return 0;
        
        int depth = getDepth(root);
        
        if(depth == 0) return 1;
        
        int left = 1, right = (int)Math.pow(2,depth)-1;
        
        int pivot;
        
        while(left <= right){
            pivot = left + (right - left)/2;
            if(exists(pivot, depth, root)) left = pivot + 1;
            else right = pivot - 1;
        }
        return (int) Math.pow(2, depth) - 1 + left;
    }
    private int getDepth(TreeNode root){
        int depth = 0;
        while(root.left != null){
            root = root.left;
            ++depth;
        }
        return depth;
    }
    
    private boolean exists(int n, int d, TreeNode node){
        int left = 0, right = (int)Math.pow(2,d) - 1;
        int pivot;
        for(int i = 0; i < d; i ++){
            pivot = left + (right - left)/2;
            if(n <= pivot){
                node = node.left;
                right = pivot;
            }
            else{
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
    }
}

