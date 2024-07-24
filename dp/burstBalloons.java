class Solution {
    public int maxCoins(int[] nums) {
        int arr[] = new int[nums.length+2];
        arr[0] = arr[arr.length-1] = 1;

        System.arraycopy(nums,0,arr,1,nums.length);
        
        int dp[][] = new int[arr.length][arr.length];
        for(int len = 2 ; len < arr.length ; len++)
        {
            for(int left = 0 ; left < arr.length-len ; left++)
            {
                int right = left+len;
                for(int k = left+1 ; k < right ; k++)
                {
                    dp[left][right] = Math.max(dp[left][right] , dp[left][k]+dp[k][right]+arr[left]*arr[k]*arr[right]);
                }
            }
        }

        return dp[0][arr.length-1];
    }
}