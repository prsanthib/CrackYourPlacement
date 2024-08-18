class Solution {
    public Node connect(Node root) {
        if(root == null)
        {
            return null;
        }
        //level order traversal
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty())
        {
            Node curr = q.remove();
            if(curr == null)
            {
                if(q.isEmpty())
                {
                    break;
                } 
                q.add(null);
            }
            else
            {
                curr.next = q.peek();
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
        return root;
    }
}
