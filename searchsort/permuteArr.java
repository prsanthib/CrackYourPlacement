//permute arrays such the sum of 2 ele in both arrays is greater than k
import java.util.*;
class permuteArr
{
    public static boolean isPossible(int a1[] , int a2[] , int k)
    {
        //sort one arr in asc and other in desc
        Arrays.sort(a1);
        Arrays.sort(a2);

        for(int i = 0 ; i < a1.length ; i++)
        {
            if(a1[i]+a2[a2.length-1-i] < k)
            {
                return false;
            }
        }

        return true;
    }
    public static void main(String args[])
    {
        int a1[] = {2,1,3};
        int a2[] = {7,2,9};
        int k = 10;

        System.out.println(isPossible(a1,a2,k));
    }
}