class Solution {
    public static void inorder(TreeNode root, ArrayList<Integer> al)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.left,al);
        al.add(root.val);
        inorder(root.right,al);
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> al= new ArrayList<>();
        
        if(k <= 0)
        {
            return 0;
        }
        inorder(root,al);
        return al.get(k-1);
    }
}