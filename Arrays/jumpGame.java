class Solution {
    public boolean canJump(int[] nums) {

        if(nums.length == 0 || nums.length == 1)
        {
            return true;
        }
        //make last idx 0
        nums[nums.length-1] = Integer.MIN_VALUE;
        int idx = nums.length-1;
        boolean flag = false;
        for(int i = nums.length-2 ; i >= 0 ; i--)
        {
            for(int j = i+1 ; j <= i+nums[i] && j < nums.length; j++)
            {
                if( nums[j] == Integer.MIN_VALUE)
                {
                    if(i == 0)
                    {
                        flag = true;
                    }
                    nums[i] = Integer.MIN_VALUE;
                }
            }
        }

        return flag;

    }
}