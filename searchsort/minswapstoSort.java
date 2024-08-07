class Solution
{
    static class pair
    {
        int val;
        int idx;
        public pair(int v , int i)
        {
            val = v;
            idx = i;
        }
        
    }
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        
        int swaps = 0;
        pair[] arr = new pair[nums.length];
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            arr[i] = new pair(nums[i],i);
        }
        
        Arrays.sort(arr,Comparator.comparingInt(p -> p.val));
        
        boolean visited[] = new boolean[nums.length];
        
        for(int i = 0 ; i < arr.length ; i++)
        {
            if(visited[i] || arr[i].idx == i)
            {
                continue;
            }
            
            int j = i;
            int cyclesize = 0;
            
            while(!visited[j])
            {
                visited[j] = true;
                j = arr[j].idx;
                cyclesize++;
            }
            
            if(cyclesize>0)
            {
                swaps += cyclesize-1;
            }
        }
        
        return swaps;
    }
}