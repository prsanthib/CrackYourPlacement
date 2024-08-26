class Solution
{

    public int maximizeCuts(int n, int x, int y, int z)
    {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        
        dp[0] = 0;
        
        for(int i = 1 ; i < n+1 ; i++)
        {
            if(i >= x && dp[i-x] != -1)
            {
                dp[i] = Math.max(dp[i] , dp[i-x]+1);
            }
            if(i >= y && dp[i-y] != -1)
            {
                dp[i] = Math.max(dp[i] , dp[i-y]+1);
            }
            if(i >= z && dp[i-z] != -1)
            {
                dp[i] = Math.max(dp[i] , dp[i-z]+1);
            }
        }
        
        return dp[n] == -1 ? 0 : dp[n];
    }
}
