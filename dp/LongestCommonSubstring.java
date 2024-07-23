class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        int dp[][] = new int[n+1][m+1];
        // if S1 = empty or s2 = empty the ans would be 0
        int maxLen = Integer.MIN_VALUE;
        for(int i = 1 ; i < n+1 ; i++)
        {
            for(int j = 1 ; j < m+1 ; j++)
            {
                if(S1.charAt(i-1) == S2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                    maxLen = Math.max(maxLen,dp[i][j]);
                }
                else
                {
                    dp[i][j] = 0;
                }
            }
        }
        
        if(maxLen == Integer.MIN_VALUE)
        {
            return 0;
        }
        return maxLen;
    }
}