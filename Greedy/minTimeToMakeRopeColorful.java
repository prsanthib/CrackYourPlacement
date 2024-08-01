class Solution {
    public int minCost(String colors, int[] neededTime) {
        if(colors.length() == 0 || colors.length() == 1)
        {
            return 0;
        }

        int minTime = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        char prevClr = colors.charAt(0);

        for(int i = 1 ; i < colors.length() ; i++)
        {
            int Extracount  = 0;
            if(prevClr == colors.charAt(i))
            {
                pq.add(neededTime[i-1]);
                while(i < colors.length() && prevClr == colors.charAt(i) )
                {
                    Extracount++;
                    pq.add(neededTime[i]);
                    i++;
                }
                i--;
                while(Extracount > 0)
                {
                    minTime += pq.remove();
                    Extracount--;
                }
                pq.clear();
            }
            else
            {
                prevClr = colors.charAt(i);
            }
        }

        return minTime;
        
    }
}