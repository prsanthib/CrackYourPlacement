class Solution {

    public static void fun(TreeNode root , List<String> al , String str)
    {
        if(root.left == null && root.right == null)
        {
            str += root.val;
            al.add(str);
            return ;
        }

        str+=root.val+"->";
        if(root.left != null)
        {
            fun(root.left, al , str);
        }
        if(root.right != null)
        {
            fun(root.right , al , str);
        }
        str = str.substring(0,str.length()-3);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> al = new ArrayList<>();
        fun(root,al,"");
        return al;
    }
}