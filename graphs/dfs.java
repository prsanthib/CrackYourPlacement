class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj,boolean visited[] , ArrayList<Integer> al,int i)
    {
        visited[i] = true;
        al.add(i);
        for(int j = 0 ; j < adj.get(i).size() ; j++)
        {
            if(!visited[adj.get(i).get(j)])
            {
             dfs(adj,visited,al,adj.get(i).get(j));
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[] = new boolean[V];
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i = 0 ; i < adj.size() ; i++)
        {
            if(!visited[i])
            {
                dfs(adj,visited,al,i);
            }
        }
        return al;
    }
}