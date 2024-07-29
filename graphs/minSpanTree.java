
class Solution {
    
    static class pair implements Comparable<pair>
    {
        int s;
        int d;
        int w;
        public pair(int s , int d, int w)
        {
            this.s = s;
            this.d = d;
            this.w = w;
        }
        
        @Override
        
        public int compareTo(pair p)
        {
            return this.w - p.w;
        }
    }
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<pair> pq = new PriorityQueue<>();
        //pq.add(0,0);
        boolean visit[] = new boolean[V];
        pq.add(new pair(0,0,0));
        int cost = 0;
        while(!pq.isEmpty())
        {
            pair curr = pq.remove();
            if(!visit[curr.d])
            {
                visit[curr.d] = true;
                cost += curr.w;
                for(int i = 0 ; i < adj.get(curr.d).size() ; i++)
                {
                    int []arr = adj.get(curr.d).get(i);
                    pq.add(new pair(curr.d,arr[0],arr[1]));
                }
            }
        }
        return cost;
    }
}
