class Solution {

    static boolean flag = true;
    public static int ht(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int l = ht(root.left);
        int r = ht(root.right);
        int diff = Math.abs(l-r);

        if(diff >= 2)
        {
            flag = false;
        }
        return Math.max(l,r)+1;
    }

    public boolean isBalanced(TreeNode root) {
        flag = true;
        ht(root);
        return flag;
    }
}
