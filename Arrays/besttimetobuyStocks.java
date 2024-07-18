class Solution {
    public int maxProfit(int[] prices) {
        int bp = Integer.MAX_VALUE;
        int maxprofit = Integer.MIN_VALUE;
        for(int i = 0 ; i < prices.length ; i++)
        {
            int sp = prices[i];
            if(bp < sp)
            {
                maxprofit = Math.max(maxprofit,sp-bp);
            }
            else
            {
                bp = sp;
            }
        }

        if(maxprofit == Integer.MIN_VALUE)
        {
            maxprofit = 0;
        }
        return maxprofit;
    }
}