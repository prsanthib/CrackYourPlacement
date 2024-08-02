class Solution {
    public int maximumProduct(int[] nums) {
        if(nums.length < 3)
        {
            return -1;
        }

        Arrays.sort(nums);
        int p1 = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int p2 = nums[0]*nums[1]*nums[nums.length-1];

        return Math.max(p1,p2);
    }
}