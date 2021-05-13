class rightSideView {
    // Given the root of a binary tree, imagine yourself standing on the right side of it, 
    // return the values of the nodes you can see ordered from top to bottom.


    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode curr = q.poll();
            res.add(curr.val);

            if (curr.right != null)
                q.offer(curr.right);
            if (curr.left != null)
                q.offer(curr.left);
            size--;
            while (size != 0) {
                curr = q.poll();
                if (curr.right != null)
                    q.offer(curr.right);
                if (curr.left != null)
                    q.offer(curr.left);

                size--;
            }

        }
        return res;
    }
}
