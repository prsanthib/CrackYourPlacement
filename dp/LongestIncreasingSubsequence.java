import java.util.*;
class Solution {
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++)
        {
            set.add(nums[i]);
        }

        Integer arr[] = new Integer[set.size()];
        int p = 0;
        for(Integer s : set)
        {
            arr[p] = s;
            p++;
        }
        Arrays.sort(arr,Collections.reverseOrder());
       
        //find lcs between arr and nums

        int dp[][] = new int[nums.length+1][arr.length+1];

        for(int i = 1 ; i < dp.length ; i++)
        {
            for(int j = 1 ; j < dp[0].length ; j++)
            {
                if(nums[i-1] == arr[j-1])
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else
                {
                    int a = dp[i-1][j];
                    int b = dp[i][j-1];
                    dp[i][j] = Math.max(a,b);
                }
            }
        }

        return dp[nums.length][arr.length];

    }
}