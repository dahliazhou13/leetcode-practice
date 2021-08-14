class flatten {
    // Given the root of a binary tree, flatten the tree into a "linked list":

    // The "linked list" should use the same TreeNode class where the right
    // child pointer points to the next node in the list and the left child
    // pointer is always null.
    // The "linked list" should be in the same order as a pre-order traversal
    // of the binary tree.
    /**Preorder solution
    public void flatten(TreeNode root) {
        if(root == null) return;
        List<TreeNode> nodeList = new ArrayList<>();
        preOrder(root, nodeList);
        TreeNode prev = root;
        TreeNode curr = root;
        for(int i = 1; i < nodeList.size(); i++){
            curr = nodeList.get(i);
            prev.left = null;
            prev.right = curr;
            prev = curr;
        }
        curr.left = null;
        curr.right = null;
    }
    
    private void preOrder(TreeNode root, List<TreeNode> nodeList){
        nodeList.add(root);
        if(root.left!=null) preOrder(root.left, nodeList);
        if(root.right != null) preOrder(root.right, nodeList);
    }
    */

    public void flatten(TreeNode root) {
        flattenTree(root);
    }
    
    private TreeNode flattenTree(TreeNode root){
        if(root == null || (root.left == null && root.right == null)) return root;
        
        TreeNode leftLeaf = flattenTree(root.left);
        TreeNode rightLeaf = flattenTree(root.right);
        
        if(leftLeaf != null){
            leftLeaf.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        return rightLeaf == null ? leftLeaf : rightLeaf;
    }

}
