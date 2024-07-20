class Solution {
    public static boolean isSym(TreeNode r1 , TreeNode r2)
    {
        if(r1 == null && r2 == null)
        {
            return true;
        }

        if(r1 == null || r2 == null)
        {
            return false;
        }

        if(r1.val != r2.val)
        {
            return false;
        }

        return isSym(r1.left,r2.right) && isSym(r2.left,r1.right);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        return isSym(root.left,root.right);
    }
}