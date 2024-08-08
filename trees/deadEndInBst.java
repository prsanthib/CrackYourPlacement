class Solution
{
    public static boolean util(Node root , int min , int max)
    {
        if(root == null)
        {
            return false;
        }
        
        if(min == max)
        {
            return true;
        }
        
        return util(root.left,min,root.data-1) || util(root.right,root.data+1,max);
        
    }
    
    public static boolean isDeadEnd(Node root)
    {
        return util(root,1,Integer.MAX_VALUE);
    }
}