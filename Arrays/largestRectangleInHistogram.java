class Solution {
    public int largestRectangleArea(int[] heights) {
        int left[] = new int[heights.length];
        int right[] = new int[heights.length];
        Stack<Integer> s = new Stack<>();

        //left min
        for(int i = 0 ;i < heights.length ; i++)
        {
            while(!s.isEmpty() && heights[i]<=heights[s.peek()])
            {
                s.pop();
            }

            if(s.isEmpty())
            {          
                left[i] = -1;
            }
            else
            {
                left[i] = s.peek();
            }
            s.push(i);
        }

         //right min
         s.clear();
        for(int i = heights.length-1 ;i >= 0 ; i--)
        {
            while(!s.isEmpty() && heights[i]<=heights[s.peek()])
            {
                s.pop();
            }

            if(s.isEmpty())
            {
                right[i] = heights.length;
            }
            else
            {
                right[i] = s.peek();
            }
            s.push(i);
        }
    

    int maxArea = 0;
    int currArea = 0;
     for(int i = 0 ; i < heights.length ; i++)
     {
        
        int ht = heights[i];
        int width = right[i]-left[i]-1;
        currArea = ht*width;

        maxArea = Math.max(currArea,maxArea);
     }

     return maxArea;
    }

}