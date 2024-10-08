class Solution {
    public static TreeNode fun(int nums[] , int s , int e)
    {
        if(s>e)
        {
            return null;
        }
        int mid = (s+e)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = fun(nums,s,mid-1);
        root.right = fun(nums,mid+1,e);

        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = fun(nums,0,nums.length-1);
        return root;
    }
}