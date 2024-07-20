class Solution {
    public static void inOrder(TreeNode root , List<Integer> al)
    {
        if(root == null)
        {
            return ;
        }
        inOrder(root.left,al);
        al.add(root.val);
        inOrder(root.right,al);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        inOrder(root,al);
        return al;
    }
}