//without using extra space and in O(n) time complexity
class Solution {
    public void sortColors(int[] nums) {
        
        // don use extra space
        // count all the colors
        int i = 0;
        int j = 0;
        int k = 0;
        for(int t = 0 ; t < nums.length ; t++)
        {
            if(nums[t] == 0)
            {
                i++;
            }
            if(nums[t] == 1)
            {
                j++;
            }
            if(nums[t] == 2)
            {
                k++;
            }
        }

        int p = 0;
        while(p<i)
        {
            nums[p] = 0;
            p++;
        }
        while(p < j+i)
        {
            nums[p] = 1;
            p++;
        }
        while(p < i+j+k)
        {
            nums[p] = 2;
            p++;
        }

    }
}