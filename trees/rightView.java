class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> al =  new ArrayList<>();
        if(root == null)
        {
            return al;
        }

        q.add(root);
        q.add(null);
        int i = 0;

        while(!q.isEmpty())
        {
            TreeNode curr = q.remove();
            if(curr == null)
            {
                al.add(i);
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
                i = curr.val;
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

        return al;
    }
}
