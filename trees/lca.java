class Solution {

    static ArrayList<TreeNode> al = new ArrayList<>();
    public static boolean path(TreeNode root , TreeNode p)
    {
        if(root == null)
        {
            return false;
        }         
        if(root.val == p.val)
        {
            al.add(root);
            return true;
        }
        al.add(root);

        if(path(root.left , p) == false && path(root.right ,p) == false)
        {
            al.remove(al.size()-1);
            return false;
        }
        
        return true;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        ArrayList<TreeNode> al1 = new ArrayList<>();
        ArrayList<TreeNode> al2 = new ArrayList<>();

        al.clear();
        
        if(path(root,p))
        {
        al1 = new ArrayList<>(al);
        }
        
        al.clear();
        
        if(path(root,q)){
        al2 = new ArrayList<>(al);
        }
       
        for(int i = 0 ; i< al1.size() ; i++)
        {
            System.out.print(al1.get(i).val+" ");
        }

        System.out.println();
        for(int i = 0 ; i< al2.size() ; i++)
        {
            System.out.print(al2.get(i).val+" ");
        }

        int size = Math.min(al1.size() , al2.size());
        TreeNode prev = root;
        for(int i = 0 ; i < size ; i++)
        {
            if(al1.get(i).val != al2.get(i).val)
            {
                break;
            }
            prev = al1.get(i);
        }

        return prev;

    }
}