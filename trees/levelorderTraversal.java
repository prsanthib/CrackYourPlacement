class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        if(root == null)
        {
            return res;
        }

        q.add(root);
        q.add(null);
        
        while(!q.isEmpty())
        {
            TreeNode curr = q.remove();
            if(curr == null)
            {
                res.add(new ArrayList<>(al));
                al.clear();
                if(q.isEmpty())
                {
                    break;
                }
                else
                {
                    q.add(null);
                }
            }
            else
            {
                al.add(curr.val);
                if(curr.left != null)
                {
                    q.add(curr.left);
                }
                if(curr.right != null)
                {
                    q.add(curr.right);
                }
            }
        } 
        return res;
    }
}