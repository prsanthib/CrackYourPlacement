//Minimum cost for acquiring all coins with k extra coins allowed with every coin
import java.util.*;
class minCosttoAcquireCoins
{
    public static void  main(String args[])
    {
        int[] arr = {100,20,50,10,2,5};
        int k = 3;
        Arrays.sort(arr);
        int n = arr.length;

        int i = 0;
        int cost = 0;
        while(n>0)
        {
            cost+=arr[i];
            n = n-k-1;
            i++;
        }

        System.out.println("Minimum cost is "+cost);
    }
}