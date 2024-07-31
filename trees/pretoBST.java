static class Solution {
    
    public static Node build(Node root , int idx , int[] arr)
    {
        Node temp = new Node(arr[idx]);
        if(root == null)
        {
            return temp;
        }
        if(arr[idx] > root.data)
        {
            root.right = build(root.right,idx, arr);
        }
        if(arr[idx] < root.data)
        {
            root.left = build(root.left,idx,arr);
        }
        
        return root;
    }
    // Function that constructs BST from its preorder traversal.
    public Node Bst(int pre[], int size) {
        Node root = null;
        for(int i = 0 ; i < pre.length ; i++)
        {
             root = build(root,i,pre);
        }
        
        return root;
    }
}