import java.util.*;

class Solution {
    static class Info {
        int u;      
        int cost;   
        int stops;  

        public Info(int u, int cost, int stops) {
            this.u = u;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            graph[flight[0]].add(new int[]{flight[1], flight[2]}); 
        }

        
        int[][] dist = new int[n][k + 2];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        

        PriorityQueue<Info> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        queue.add(new Info(src, 0, 0)); 

        dist[src][0] = 0;

        while (!queue.isEmpty()) {
            Info curr = queue.poll();
            int u = curr.u;
            int cost = curr.cost;
            int stops = curr.stops;

            if (u == dst) {
                return cost;
            }

            if (stops > k) {
                continue;
            }

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int weight = edge[1];
                
                if (cost + weight < dist[v][stops + 1]) {
                    dist[v][stops + 1] = cost + weight;
                    queue.add(new Info(v, cost + weight, stops + 1));
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= k + 1; i++) {
            minCost = Math.min(minCost, dist[dst][i]);
        }

        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}
