//the idea is we perform bellmanford algo for v-1 times
//if for vth time if we get even more shortest path then there exists a negative cycle

import java.util.*;
class detectNegativeCycle
{
    static class Edge
    {
        int src;
        int dest;
        int wt;

        public Edge(int s , int d ,int w)
        {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static boolean hasNegative(ArrayList<Edge> graph[])
    {

        int dist[] = new int[graph.length];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;

        for(int i = 0 ; i < graph.length-1 ; i++)
        {
            for(int j = 0 ; j < graph.length ; j++)
            {
                for(int k = 0 ; k < graph[j].size() ; k++)
                {
                    int u = graph[j].get(k).src ;
                    int v = graph[j].get(k).dest ;
                    int w = graph[j].get(k).wt ;

                    if(dist[u] != Integer.MAX_VALUE && dist[u]+w < dist[v])
                    {
                        dist[v] = dist[u]+w;
                    }
                }
            }
        }

        for(int j = 0 ; j < graph.length ; j++)
        {
            for(int k = 0 ; k < graph[j].size() ; k++)
            {
                int u = graph[j].get(k).src ;
                int v = graph[j].get(k).dest ;
                int w = graph[j].get(k).wt ;

                if(dist[u] != Integer.MAX_VALUE && dist[u]+w < dist[v])
                {
                    return true;
                }
            }
        }

            return false;
    }

    public static void main(String args[])
    {
        ArrayList<Edge> graph[] = new ArrayList[5];
        for(int i = 0 ; i < 5 ; i++)
        {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 4));
        graph[0].add(new Edge(0, 2, 5));
        graph[1].add(new Edge(1, 2, 6));
        graph[2].add(new Edge(2, 3, 5));
        graph[3].add(new Edge(3, 1, 2));

        System.out.println(hasNegative(graph));
    }
}