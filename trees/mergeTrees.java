class Solution {
    public static TreeNode util(TreeNode root1, TreeNode root2)
    {
        if(root1 == null && root2 == null)
        {
            return null;
        }

        int sum = 0;
        
        if(root1 != null && root2 != null)
        {
            sum = root1.val+root2.val;
        }
        if(root1 == null)
        {
            sum = root2.val;
        }
        if(root2 == null)
        {
            sum = root1.val;
        }

        TreeNode newNode = new TreeNode(sum);
        TreeNode l1 = root1 == null || root1.left == null ? null : root1.left;
        TreeNode l2 = root2 == null || root2.left == null ? null : root2.left;
        TreeNode r1 = root1 == null || root1.right == null ? null : root1.right;
        TreeNode r2 = root2 == null || root2.right == null ? null : root2.right; 
        
        newNode.left = util(l1,l2);
        newNode.right = util(r1,r2);
        
        return newNode;
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
         return util(root1,root2);
    }
}
