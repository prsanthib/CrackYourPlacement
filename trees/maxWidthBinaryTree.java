class Solution {
    static class pair
    {
        TreeNode node;
        int c;
        public pair(TreeNode node , int c)
        {
            this.node = node;
            this.c = c;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
        {
            return 0;
        }

        Deque<pair> dq = new ArrayDeque<>();
        dq.add(new pair(root,1));
        int count = 0;
        while(!dq.isEmpty())
        {
            int size = dq.size();
            int si = dq.getFirst().c;
            count = Math.max(count , dq.getLast().c-dq.getFirst().c+1);
           
            for(int i = 0 ; i < size ; i++)
            {
                pair curr = dq.pop();
                int idx = curr.c - si;
                if(curr.node.left != null)
                {
                    dq.addLast(new pair(curr.node.left , idx*2));
                }
                if(curr.node.right != null)
                {
                    dq.addLast(new pair(curr.node.right , idx*2+1));
                }
            }
        }
        return count;
    }
}