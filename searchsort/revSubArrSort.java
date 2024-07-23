//reversing a subarray makes it sorted
//Check if reversing a sub array make the array sorted

class revSubArrSort
{

    public static boolean isTrue(int arr[])
    {
        int i = 1;
        int j = 0;
        while(i<arr.length)
        {
            if(arr[j]>arr[i])
            {
                break;
            }
            i++;
            j++;
        }

        //already sorted
        if(i == arr.length)
        {
            return true;
        }

        int start = j;

        while(i < arr.length)
        {
            if(arr[j]<arr[i])
            {
                break;
            }
            i++;
            j++;
        }

        int end = j;

        return sortAfterRev(arr,start,end);
    }

    public static boolean sortAfterRev(int arr[] , int s , int e)
    {
        int j = 0;
        for(int i = s ; i < s+(e-s)/2 ; i++)
        {
            int temp = arr[i];
            arr[i] = arr[e-j];
            arr[e-j] = temp;
            j++;
        }

        //check if arr is sorted

        for(int i = 0 ; i < arr.length-1 ; i++)
        {
            if(arr[i]>arr[i+1])
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[])
    {
        int arr[] = {1,2,5,4,3,6,7,3};
        System.out.println(isTrue(arr));
    }
}