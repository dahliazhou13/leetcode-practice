class binaryTreePaths {
    List<String> res = new ArrayList<>();
    TreeNode root;

    public List<String> binaryTreePaths(TreeNode root) {
        this.root = root;
        if (root == null)
            return res;
        helper(root, new StringBuilder());
        return res;
    }

    private void helper(TreeNode node, StringBuilder sb) {
        if (node != root)
            sb.append("->");
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            res.add(sb.toString());
        }

        if (node.left != null)
            helper(node.left, new StringBuilder(sb));

        if (node.right != null)
            helper(node.right, new StringBuilder(sb));

    }
}
