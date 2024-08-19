class Solution {
    
    private int maxPathSum;
    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        findMaxPathSum(root);
        return maxPathSum;
    }

    private int findMaxPathSum(TreeNode node) {
        if (node == null) return 0;

        int leftMax = Math.max(findMaxPathSum(node.left), 0); 

        int rightMax = Math.max(findMaxPathSum(node.right), 0);

        int currentMax = node.val + leftMax + rightMax;

        maxPathSum = Math.max(maxPathSum, currentMax);

        return node.val + Math.max(leftMax, rightMax);
    }

}