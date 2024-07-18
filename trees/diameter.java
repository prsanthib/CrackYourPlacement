class Solution {
    static class Info
    {
        int ht;
        int dia;
        public Info(int h,int d)
        {
            ht = h;
            dia = d;
        }
    }
    public static Info diaht(TreeNode root)
    {
        if(root == null)
        {
            return new Info(0,0);
        }

       Info lInfo = diaht(root.left);
       Info rInfo = diaht(root.right);

       int ht = Math.max(lInfo.ht,rInfo.ht)+1;
       int dia = Math.max(Math.max(lInfo.dia,rInfo.dia),lInfo.ht+rInfo.ht);

       return new Info(ht,dia);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Info info = diaht(root);
        return info.dia;        
    }
}