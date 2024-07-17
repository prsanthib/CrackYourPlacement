class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        // Your code here
        Arrays.sort(arr);
        
        int i = 0;
        while(i < arr.length && arr[i] <= 0)
        {
            i++;
        }
        
        if(i == arr.length)
        {
            return 1;
        }
        
        int j = 1;
        while(i < arr.length)
        {
            if(arr[i] != j)
            {
                return j;
            }
            while(i < arr.length && arr[i]==j)
            {
                i++;
            }
            j++;
        }
        
        return j;
    }
}