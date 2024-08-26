class Solution {
    public int maxProduct(int[] nums) {

        if(nums.length == 0)
        {
            return 0;
        }

        int maxProd = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for(int i = 1 ; i < nums.length ; i++)
        {
            int n = nums[i];
            //swap if n is negative because after multipliying 
            //it gets reversed
            if(n < 0)
            {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(n , n*currMax);
            currMin = Math.min(n , n*currMin);

             maxProd = Math.max(maxProd,currMax);
        }

        return maxProd;
    }
}

//this is changed