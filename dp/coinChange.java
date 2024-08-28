class Solution {
    public int coinChange(int[] c, int a) {
        int dp[][] = new int[c.length+1][a+1];
        //no coins means for any amount we cannot give the change
        for(int i = 1 ; i < a+1 ; i++)
        {
            dp[0][i] = Integer.MAX_VALUE;
        }
        //no amount means 0 coins 

        for(int i = 1 ; i < dp.length ; i++)
        {
            for(int j = 1 ; j < dp[0].length ; j++)
            {
                if(c[i-1] <= j)
                {
                    int d = Integer.MAX_VALUE;
                    int b = Integer.MAX_VALUE;
                    if(dp[i][j-c[i-1]] != Integer.MAX_VALUE)
                    {
                        d = 1+dp[i][j-c[i-1]];
                    }
                    
                    b = dp[i-1][j];
                    dp[i][j] = Math.min(b,d);
                     
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[c.length][a] == Integer.MAX_VALUE ? -1 : dp[c.length][a];
    }
}