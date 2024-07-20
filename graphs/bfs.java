class Solution {
    // Function to return Breadth First Traversal of given graph.
    
    public static void bfs(ArrayList<ArrayList<Integer>> al,boolean visit[] , int i, ArrayList<Integer> res)
    {
       
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty())
        {
            int curr = q.remove();
            if(!visit[curr])
            {
                visit[curr] = true;
                res.add(curr);
                for(int j = 0 ; j < al.get(curr).size() ; j++)
                {
                    q.add(al.get(curr).get(j));
                }
            }
        }
    }
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visit[] = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        bfs(adj,visit,0,res);
        return res;
         
    }
}