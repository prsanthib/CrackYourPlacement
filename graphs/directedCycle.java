class Solution {
    // Function to detect cycle in a directed graph.
    public static boolean dfs(ArrayList<ArrayList<Integer>>adj,int src,boolean visit[],boolean []s)   
    {
        visit[src] = true;
        s[src] = true;
        
        for(int i = 0 ; i < adj.get(src).size() ; i++)
        {
            if(!visit[adj.get(src).get(i)])
            {
                if(dfs(adj,adj.get(src).get(i),visit,s))
                {
                    return true;
                }
            }
            else if(s[adj.get(src).get(i)])
            {
                return true;
            }
            
        }
        
        s[src] = false;
        return false;
    }
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean visit[] = new boolean[V];
        boolean s[] = new boolean[V];
        
        for(int i = 0 ; i < V ; i++)
        {
            if(!visit[i])
            {
                if(dfs(adj,i,visit,s))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
}