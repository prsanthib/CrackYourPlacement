class Tree
{
    public static void inorder(Node root , ArrayList<Integer> al)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.left,al);
        al.add(root.data);
        inorder(root.right,al);
    }
    
    public static float findMedian(Node root)
    {
        ArrayList<Integer> al = new ArrayList<>();
        inorder(root,al);
        if(al.size() % 2 != 0)
        {
            return al.get(al.size()/2);
        }
        
        return (al.get(al.size()/2)+al.get((al.size()/2)-1))/(float)2;
    }
}