class GfG {
    
    public static Node lcaUtil(Node root , int a , int b)
    {
        if(root == null)
        {
            return null;
        }
        
        if(root.data == a || root.data == b)
        {
            return root;    
        }
        
        Node left = lcaUtil(root.left , a , b);
        Node right = lcaUtil(root.right , a , b);
        
        if(left != null && right != null)
        {
            return root;
        }
        
        return left != null ? left : right;
    }
    
    public static int distance(Node root , int a , int dis)
    {
        if(root == null)
        {
            return 0;
        }
        
        if(root.data == a)
        {
            return dis;
        }
        
        int left = distance(root.left , a , dis+1);
        if(left > 0)
        {
            return left;
        }
        return distance(root.right , a , dis+1);
        
    }
    
    int findDist(Node root, int a, int b) {
        Node lca = lcaUtil(root,a,b);
        int d1 = distance(lca,a,0);
        int d2 = distance(lca,b,0);
        return d1+d2;
    }
}