class Solution {
    public static TreeNode util(int[] pre , int preStart , int preEnd , int[] post , int postStart , int postEnd)
    {
        if(preStart > preEnd || postStart > postEnd)
        {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);

        if(preStart == preEnd)
        {
            return root;
        }

        int leftNode = pre[preStart+1];

        int leftEndIdx = postStart;

        while(post[leftEndIdx] != leftNode)
        {
            leftEndIdx++;
        }

        int size = leftEndIdx - postStart+1;

        root.left = util(pre,preStart+1,preStart+size,post,postStart,leftEndIdx);
        root.right = util(pre,preStart+size+1,preEnd,post,leftEndIdx+1,postEnd);

        return root;
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre.length == 0)
        {
            return null;
        }
        return util(pre,0,pre.length-1,post,0,post.length-1);

    }
}