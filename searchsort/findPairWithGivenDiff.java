class Solution {
    public int findPair(int n, int x, int[] arr) {
        // code here
        if(arr.length < 2)
        {
            return -1;
        }
        
        Arrays.sort(arr);
        int l = 0;
        int r = 1;
        while(r < arr.length)
        {
            int diff = arr[r]-arr[l];
            if(diff == x && l != r)
            {
                return 1;
            }
            else if(diff < x )
            {
                r++;
            }
            else
            {
                l++;
                if(l == r)
                {
                    r++;
                }
            }
        }
        
        return -1;
    }
}
