class radixSort
{
    public static int Findmax(int a[])
    {
        int m = Integer.MIN_VALUE;
        for(int i = 0 ; i < a.length ; i++)
        {
            m = Math.max(m,a[i]);
        }

        return m;
    }

    public static void radix(int a[] , int e)
    {
        //count sort for digits at eth place
        int c[] = new int[10];
        int output[] = new int[a.length];

        for(int i = 0 ; i < a.length ; i++)
        {
            c[(a[i]/e)%10]++;
        }

        for(int i = 1 ; i < 10 ; i++)
        {
            c[i] = c[i]+c[i-1];
        }

        for(int i = a.length-1 ; i >= 0 ; i--)
        {
            output[c[(a[i]/e)%10]-1] = a[i];
            c[(a[i]/e)%10]--;
        }

        for(int i = 0 ; i < a.length ; i++)
        {
            a[i] = output[i];
        }
    }

    public static void print(int a[])
    {
        for(int i = 0 ; i < a.length ; i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int max = Findmax(arr);
        for(int i = 1 ; max/i > 0; i = i*10)
        {
            radix(arr,i);
        }

        print(arr);
    }
}