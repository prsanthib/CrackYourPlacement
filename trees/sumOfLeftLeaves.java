class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesHelper(root, false);
    }
     private int sumOfLeftLeavesHelper(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            if (isLeft) {
                return node.val;
            } else {
                return 0;
            }
        }

        return sumOfLeftLeavesHelper(node.left, true) + sumOfLeftLeavesHelper(node.right, false);
     }
    
}