// Given a sorted array and a value x, the ceiling of x is the smallest element in an array greater than or equal to x, and the floor is the greatest element smaller than or equal to x. Assume that the array is sorted in non-decreasing order. Write efficient functions to find the floor and ceiling of x. 
class ceiling
{
    public static int ceil(int[] arr , int x)
    {
        if(x == arr[0])
        {
            return 0;
        }

        for(int i = 1 ;  i < arr.length-1 ; i++)
        {
            if(arr[i] == x)
            {
                return i;
            }

            if(arr[i]<x && arr[i+1] >x)
            {
                return i+1;
            }
        }

        return -1;
    }

    public static void main(String args[])
    {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int i  = ceil(arr,5);
        if(i == -1)
        {
            System.out.println("No ceiling exists");
        }
        else
        {
            System.out.println("ceiling is "+arr[i]);
        }


    }
}