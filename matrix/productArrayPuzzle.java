class Solution {
    public static long[] productExceptSelf(int nums[]) {
        
        long[] lp = new long[nums.length];
        long[] rp = new long[nums.length];
        
        long[] res = new long[nums.length];
        
        lp[0] = 1;
        
        for(int i = 1 ; i < nums.length ; i++)
        {
            lp[i] = nums[i-1]*lp[i-1];    
        }
        
        rp[nums.length-1] = 1;
        for(int i = nums.length-2 ; i >= 0 ; i--)
        {
            rp[i] = nums[i+1]*rp[i+1];
        }
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            res[i] = lp[i]*rp[i];
        }
        
        return res;
    }
}
