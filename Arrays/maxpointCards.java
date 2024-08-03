class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int minsum = Integer.MAX_VALUE;

        int ts = 0;
        for(int i = 0 ; i < n ; i++)
        {
            ts += cardPoints[i];
        }

        int cursum = 0;
        for(int i = 0 ; i < n-k ; i++)
        {
            cursum += cardPoints[i];
        }

        int i = 0;
        int j = n-k-1;
        minsum = Math.min(minsum,cursum);
        i++;
        j++;
        while(j < n)
        {
            cursum -= cardPoints[i-1];
            cursum += cardPoints[j];
            minsum = Math.min(minsum,cursum);
            i++;
            j++;
        }

        return ts - minsum;

    }
}