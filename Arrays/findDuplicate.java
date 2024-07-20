class Solution {
    public int findDuplicate(int[] nums) {
        //we use floyd tortoise method
        int s = nums[0];
        int f = nums[nums[0]];
        while(s != f)
        {
            s = nums[s];
            f = nums[nums[f]];
        }

        s = 0;
        while(s != f)
        {
            s = nums[s];
            f = nums[f];
        }

        return s;
    }
}