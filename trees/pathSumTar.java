class Solution {
    public static boolean fun(TreeNode root , int sum , int ts)
    {
        if(root.left == null && root.right == null)
        {
            sum += root.val;
            if(sum == ts)
            {
                return true;
            }
            return false;
        }

        sum += root.val;
        boolean f1 = false;
        boolean f2 = false;
        if(root.left != null)
        {
            f1 = fun(root.left,sum ,ts);
        }
        if(root.right != null)
        {
            f2 = fun(root.right,sum,ts);
        }
        sum -= root.val;
        return f1 || f2;
    }

    public boolean hasPathSum(TreeNode root, int tS) {
        if(root == null)
        {
            return false;
        }
        return fun( root , 0 , tS);
    }
}