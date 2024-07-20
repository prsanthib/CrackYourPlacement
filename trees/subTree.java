class Solution {

    public static boolean fun(TreeNode root , TreeNode subRoot)
    {
        if(root == null && subRoot == null)
        {
            return true;
        }

        if(root == null && subRoot != null)
        {
            return false;
        }
        if(subRoot == null)
        {
            return false;
        }

        if(root.val != subRoot.val)
        {
            return false;
        }

        return fun(root.left,subRoot.left) && fun(root.right,subRoot.right);
        
    }
    public static boolean util(TreeNode root, TreeNode subRoot)
    {
        if(root == null && subRoot == null)
        {
            return true;
        }

        if(root == null && subRoot != null)
        {
            return false;
        }

        if(subRoot == null)
        {
            return false;   
        }

        if(root.val == subRoot.val)
        {
            if(fun(root,subRoot))
            {
                return true;
            } 
        }

        //call left and right
        return util(root.left,subRoot)||util(root.right,subRoot);

    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return util(root,subRoot);
    }
}