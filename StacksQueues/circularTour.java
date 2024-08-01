class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
	    int tp = 0;
	    int td = 0;
	    int rem = 0;
	    
	    int startidx = 0;
	    for(int i = 0 ; i < petrol.length ; i++)
	    {
	        tp += petrol[i];
	        td += distance[i];
	        rem += petrol[i]-distance[i];
	        
	        if(rem < 0)
	        {
	            rem = 0;
	            startidx = i+1;
	        }
	    }
	    
	    if(tp < td)
	    {
	        return -1;
	    }
	    
	    return startidx;
	}
}