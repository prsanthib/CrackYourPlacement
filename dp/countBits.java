class Solution {
    public static int count(int n)
    {
        int c = 0;
        while(n > 0)
        {
            if((n&1) == 1)
            {
                c++;
            }
            n = n>>1;
        }
        return c;
    }
    public int[] countBits(int n) {
        int temp[] = new int[n+1];
        if(n == 0)
        {
            return temp;
        }
        temp[1] = 1;
        if(n == 1)
        {
            return temp;
        }
         temp[2] = 1;
         if(n == 2)
         {
            return temp;
         }
        for(int i = 2 ; i < n+1 ; i++)
        {
            temp[i] = count(i);
        }

        return temp;

    }
}