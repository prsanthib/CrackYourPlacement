class Solution{
    
    static int idx = 0;
    public static Node build(Node root , int pre[] , char preLN[])
    {
        if(idx >= pre.length)
        {
            return null;
        }
        Node newNode = new Node(pre[idx]);
        if(preLN[idx] == 'L')
        {
            return newNode;
        }
        idx++;
        newNode.left = build(root,pre,preLN);
        idx++;
        newNode.right = build(root,pre,preLN);
        return newNode;
    }
    
    Node constructTree(int n, int pre[], char preLN[]){
        if(n == 0)
        {
            return null;
        }
        
        Node root = null;
        idx = 0;
        root = build(root,pre,preLN);
        
        return root;
    }
}