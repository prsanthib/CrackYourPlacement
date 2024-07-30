class Solution {
    
    public static void inorder(TreeNode root,List<Integer> al)
    {
        if(root == null)
        {
            return ;
        }
        inorder(root.left,al);
        al.add(root.val);
        inorder(root.right,al);
    } 
    public int getMinimumDifference(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        inorder(root,al);
        if(al.size() < 2)
        {
            return 0;
        }

        int diff = Integer.MAX_VALUE;
        for(int i = 0 ; i < al.size()-1 ; i++)
        {
            diff = Math.abs(Math.min(al.get(i+1)-al.get(i),diff));
        }
        return diff;
    }
}