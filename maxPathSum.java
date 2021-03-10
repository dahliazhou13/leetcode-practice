/**
 * Definition for a binary tree node.
 
 */
/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any path.

 */
class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
class Solution {
    public int maxPathSum(TreeNode root) {
        
        return helper(root).maxVal;
    }
    private Data helper(TreeNode root){
        if(root == null) return new Data(0,Integer.MIN_VALUE);
        Data left = helper(root.left);
        Data right = helper(root.right);
        int leftGain = Math.max(left.maxDirect, 0);
        int rightGain = Math.max(right.maxDirect,0);
        int maxDirect = Math.max(leftGain, rightGain) + root.val;
        
        int maxRoot = root.val + leftGain + rightGain;
        int max = Math.max(Math.max(left.maxVal, right.maxVal), maxRoot);
        return new Data(maxDirect, max);
    }
}
class Data{
    int maxDirect;
    int maxVal;
    public Data(int maxDirect, int maxVal){
        this.maxDirect = maxDirect;
        this.maxVal = maxVal;
    }
}