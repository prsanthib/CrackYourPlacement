class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int tc = 0;
        int tg = 0;
        int currgas = 0;
        int startidx = 0;
        for(int i = 0 ; i < gas.length ; i++)
        {
            tg += gas[i];
            tc += cost[i];
            currgas += gas[i]-cost[i];

            if(currgas < 0)
            {
                startidx = i+1;
                currgas = 0;
            }
        }

        if(tc > tg)
        {
            return -1;
        }

        return startidx;
    }
}