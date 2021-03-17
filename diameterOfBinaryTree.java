/**
 * Description:
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes 
 * in a tree. This path may or may not pass through the root.
 * 
 * The length of a path between two nodes is represented by the number of edges between them.
 * 
 * Definition for a binary tree node.
 */

public class diameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = getMax(root);
        
        
        return res[0];
        
        
    }
    
    private int[] getMax(TreeNode node){
        if(node == null) return new int[]{0,0};
        int[] res = new int[2];
        
        int[] left = getMax(node.left);
        int[] right = getMax(node.right);
        
        int maxchild = Math.max(left[0],right[0]);
        int depth = Math.max(left[1], right[1]) + 1;
        int maxdirect = left[1] + right[1];
        
        res[0] = Math.max(maxchild, maxdirect);
        res[1] = depth;
        return res;
    }
    
    
}