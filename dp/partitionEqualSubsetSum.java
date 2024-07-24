class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum = 0;
        for(int i = 0 ;  i < arr.length ; i++)
        {
            sum += arr[i];
        }
        
        if(sum %2 != 0)
        {
            return 0;
        }
        int sum2 = sum/2;
        
        int dp[][] = new int[N+1][sum2+1];
        
        //0 1 knapsack approach
        for(int i = 1 ; i < dp.length ; i++)
        {
            for(int j = 1 ; j < dp[0].length ; j++)
            {
                if(arr[i-1] <= j)
                {
                    dp[i][j] = Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        if(dp[N][sum2] == sum2)
        {
            return 1;
        }
        
        return 0;
    }
}