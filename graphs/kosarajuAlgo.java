
class Solution
{
    //Function to find number of strongly connected components in the graph.

    public static void dfs(ArrayList<ArrayList<Integer>> adj ,int i, boolean visited[] , Stack<Integer> stack)
    {
        visited[i] = true;
        for(int j : adj.get(i))
        {
            if(!visited[j])
            {
                dfs(adj,j, visited , stack);
            }
        }
        stack.push(i);
    }
    
    public static void dfss(ArrayList<ArrayList<Integer>> adj ,int i, boolean visited[])
    {
        visited[i] = true;
        for(int j : adj.get(i))
        {
            if(!visited[j])
            {
                dfss(adj,j, visited);
            }
        }
        
    }
    
    public static void rev(ArrayList<ArrayList<Integer>> adj,ArrayList<ArrayList<Integer>> temp)
    {
        for(int i = 0 ; i < adj.size() ; i++)
        {
            temp.add(new ArrayList<>());    
        }
        
        for(int i = 0 ; i < adj.size() ; i++)
        {
            for(int j : adj.get(i))
            {
                temp.get(j).add(i);
            }
        }
    }
    
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];
        
        for(int i = 0 ; i < V ; i++)
        {
            if(!visited[i])
            {
                dfs(adj,i,visited,stack);
            }
        }
        
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        rev(adj,temp);
        
        Arrays.fill(visited,false);
        
        int c = 0;
        while(!stack.isEmpty())
        {
            int s = stack.pop();
            if(!visited[s])
            {
            dfss(temp,s,visited);
            c++;
            }
        }
        
        return c;
    }
}
