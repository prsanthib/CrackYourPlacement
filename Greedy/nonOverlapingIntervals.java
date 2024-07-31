class Solution {
    public int eraseOverlapIntervals(int[][] i) {
        //sort based on end time
        if(i.length == 1)
        {
            return 0;
        }

        Arrays.sort(i,Comparator.comparingDouble(o -> o[1]));

        int rem = 0;
        int end = Integer.MIN_VALUE;
        for(int k = 0 ; k < i.length ; k++)
        {
            int s = i[k][0];
            int e = i[k][1];
            if(s >= end)
            {
                end = e;
            }
            else
            {
                rem++;
            }
        }

        return rem;
    }

     
}