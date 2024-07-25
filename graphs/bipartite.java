class Solution
{
    
    public static boolean fun(int V, ArrayList<ArrayList<Integer>>adj ,int src , int[] color)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        while(!q.isEmpty())
        {
            int curr = q.remove();
             
            int clr = color[curr] == 1 ? 2 : 1;
            for(int i = 0 ; i < adj.get(curr).size() ; i++)
            {
                if(color[adj.get(curr).get(i)] == -1)
                {
                    color[adj.get(curr).get(i)] = clr;
                    q.add(adj.get(curr).get(i));
                }
                else if(color[adj.get(curr).get(i)] == clr)
                {
                    continue;
                }
                else
                {
                    return false;
                }
            }
            
            
        }
        
        return true;    
    }
    
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        // use bfs
        int color[] = new int[V];
        Arrays.fill(color,-1);
        for(int i = 0 ; i < adj.size() ; i++)
        {
            if(color[i] == -1)
            {
                if(!fun(V,adj,i,color))
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}