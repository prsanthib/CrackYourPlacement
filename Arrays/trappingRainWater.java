class Solution {
    public int trap(int[] h) {
        int wl = 0;
        int leftmax[] = new int[h.length];
        leftmax[0] = h[0];
        for(int i = 1 ; i < h.length ; i++)
        {
            leftmax[i] = Math.max(leftmax[i-1],h[i]);
        }
        
        int rightmax[] = new int[h.length];
        rightmax[h.length-1] = h[h.length-1];
        for(int i = h.length-2 ; i>= 0 ; i--)
        {
            rightmax[i] = Math.max(rightmax[i+1],h[i]);
        }

        for(int i = 0 ; i < h.length ; i++)
        {
        int min = Math.min(rightmax[i],leftmax[i]);
        wl += min-h[i];
        }
        return wl;
    }
}