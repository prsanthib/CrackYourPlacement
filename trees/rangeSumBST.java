class Solution {
    public static int range(TreeNode root , int l , int h)
    {
        if(root == null)
        {
            return 0;
        }

        if(root.val < l)
        {
            return range(root.right , l , h);
        }
        
        if(root.val > h)
        {
            return range(root.left , l , h);
        }

        return root.val + range(root.left,l,h)+range(root.right,l,h);        
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        return range(root,low,high);
    }
}