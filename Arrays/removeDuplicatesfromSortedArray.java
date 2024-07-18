class Solution {
    public int removeDuplicates(int[] nums) {
        
        int count = 0;
        int prev = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] != prev)
            {
                prev = nums[i];
                nums[count] = prev;
                count++;
            }
        }

        return count;
    }
}