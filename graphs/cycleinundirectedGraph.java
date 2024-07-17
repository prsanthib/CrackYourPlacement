class Solution {
    // Function to detect cycle in an undirected graph.
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj,int i,int par,boolean visited[])
    {
        visited[i] = true;
        for(int j = 0 ; j < adj.get(i).size() ; j++)
        {
            if(!visited[adj.get(i).get(j)])
            {
                if(dfs(adj,adj.get(i).get(j),i,visited))
                {
                    return true;
                }
            }
            else
            {
                if(adj.get(i).get(j) != par)
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[] = new boolean[V];
        for(int i = 0 ; i < V ; i++)
        {
            if(!visited[i])
            {
                if(dfs(adj,i,-1,visited))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
}