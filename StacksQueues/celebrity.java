class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	for(int i = 0 ; i < n ; i++)
    	{
    	    boolean flag = true;
            for(int j = 0 ; j < n ; j++)
            {
                if(j != i && M[j][i] == 0)
                {
                    flag = false;
                    break;
                }
            }
            if(flag == true)
            {
                for(int k = 0 ; k < n ; k++)
                {
                    if(M[i][k] != 0)
                    {
                        flag = false;
                        break;
                    }
                }
                if(flag == true)
                {
                    return i;
                }
            }
    	}
    	
    	return -1;
    }
}