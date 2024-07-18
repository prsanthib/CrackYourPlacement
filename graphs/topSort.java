class Solution
{
    //Function to return list containing vertices in Topological order.
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj,boolean visited[] , Stack<Integer> stack , int i)
    {
        visited[i] = true;
        
        for(int j = 0 ; j < adj.get(i).size() ;j++)
        {
            if(!visited[adj.get(i).get(j)])
            {
                dfs(adj,visited,stack,adj.get(i).get(j));
            }
        }
        stack.push(i);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0 ; i < adj.size() ; i++)
        {
            if(!visited[i])
            {
                dfs(adj,visited,stack,i);
            }
        }
        
        int res[] = new int[V];
        for(int i = 0 ; i< V ; i++)
        {
            res[i] = stack.pop();
        }
        
        return res;
    }
}
