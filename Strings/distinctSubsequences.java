class Solution {

    // static int c = 0;
    // public static void sub(String s , int i , String res , String t )
    // {
    //     if(i == s.length())
    //     {
    //         if(res.equals(t))
    //         {
    //             c++;
    //         }
    //         return;
    //     }

    //     if(res==t)
    //     {
    //         c++;
    //     }
    //     //include
    //     sub(s,i+1,res+s.charAt(i),t);
    //     //exclude
    //     sub(s,i+1,res,t);
    // }
    public int numDistinct(String s, String t) {
        
        // c = 0;
        // sub(s,0,"",t);
        // return c;
        
        //dp approach

        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i = 0 ; i < s.length()+1 ; i++)
        {
            dp[i][0] = 1;
        }

        for(int i =  1 ; i < s.length()+1 ; i++)
        {
            for(int j = 1 ; j < t.length()+1 ; j++)
            {
                if(s.charAt(i-1) == t.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
