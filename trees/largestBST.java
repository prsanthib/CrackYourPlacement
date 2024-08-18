class Solution{
    
    static class Info
    {
        boolean isBst;
        int size;
        int min;
        int max;
        public Info(boolean isBst , int size ,int min,int max)
        {
            this.isBst = isBst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    
    public static Info bst(Node root)
    {
        if(root == null)
        {
            return new Info(true , 0 , Integer.MAX_VALUE , Integer.MIN_VALUE);
        }
        
        Info leftInfo = bst(root.left);
        Info rightInfo = bst(root.right);
        
        if(leftInfo.isBst && rightInfo.isBst && root.data > leftInfo.max && root.data < rightInfo.min)
        {
            int size = leftInfo.size + rightInfo.size + 1;
            int min = Math.min(root.data , leftInfo.min);
            int max = Math.max(root.data , rightInfo.max);
            return new Info(true , size , min , max);
        }
        
        return new Info(false , Math.max(leftInfo.size , rightInfo.size) , 0 , 0);
    }
    static int largestBst(Node root)
    {
        return bst(root).size;
    }
    
}