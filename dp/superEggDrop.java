class Solution {
    public int superEggDrop(int k, int n) {
        
        int dp[][] = new int[k+1][n+1];
        // if no eggs 0moves , no floors 0 moves 1 egg n moves 1 floor 1 move

        //one floor => 1move 
        for(int i = 1 ; i < k+1 ; i++)
        {
            dp[i][1] = 1;
        }

        //1 egg => n moves
        for(int i = 1 ; i < n+1 ; i++)
        {
            dp[1][i] = i;
        }

        for(int i = 2 ; i < k+1 ; i++)
        {
            for(int j = 2 ; j < n+1 ; j++)
            {
                //dp[i][j] = Integer.MAX_VALUE;
                // for(int m = 1 ; m <= j ; m++)
                // {
                //     // if egg breaks check lower floors with eggs-1
                //     //if egg does not break then check above floors

                //     int ans = 1+Math.max(dp[i-1][m-1],dp[i][j-m]);
                //     dp[i][j] = Math.min(dp[i][j],ans);
                // }

                // use binary search for optimal 
                int low = 1;
                int high = j;
                while(low+1 < high)
                {
                    int mid = (low+high)/2;
                    int breakcost = dp[i-1][mid-1];
                    int nobreak = dp[i][j-mid];
                    if(breakcost < nobreak)
                    {
                        low = mid;
                    }
                    else
                    {
                        high = mid;
                    }
                }

                dp[i][j] = 1 + Math.min(
                    Math.max(dp[i - 1][low - 1], dp[i][j - low]),
                    Math.max(dp[i - 1][high - 1], dp[i][j - high])
                );

            }
        }

        return dp[k][n];
    }
}