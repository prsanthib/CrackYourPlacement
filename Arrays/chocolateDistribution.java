class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a);
        int i = 0;
        int j = i+m-1;
        
        int diff = Integer.MAX_VALUE;
        while(j < a.size())
        {
            diff = Math.min(diff,a.get(j)-a.get(i));
            i++;
            j++;
        }
        
        return (long)diff;
    }
}