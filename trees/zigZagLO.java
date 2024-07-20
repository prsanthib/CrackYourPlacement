class Solution {
    public static List<List<Integer>> zz(TreeNode root)
    {
        List<List<Integer>> al = new ArrayList<>();
        if(root == null)
        {
            return al;
        }
        List<Integer> ll = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        int i = 1;
        while(!q.isEmpty())
        {
            TreeNode curr = q.remove();
            if(curr == null)
            {
                al.add(new ArrayList<>(ll));
                ll.clear();

                if(q.isEmpty())
                {
                    break;
                }
                else
                {
                    q.add(null);
                }
                i++;
            }
            else
            {
                if(i % 2 == 0)
                {
                    ll.add(0,curr.val);
                }
                else
                {
                ll.add(curr.val);
                }
                
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return zz(root);
    }
}