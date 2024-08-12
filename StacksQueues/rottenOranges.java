class Solution
{
    static class pair
    {
        int r;
        int c;
        public pair(int r ,int c)
        {
            this.r = r;
            this.c = c;
        }
    }

    public int orangesRotting(int[][] grid)
    {
        int fresh = 0;
        Queue<pair> q = new LinkedList<>();
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[0].length ; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.offer(new pair(i,j));
                }
                
                if(grid[i][j] == 1)
                {
                    fresh++;
                }
            }
        }
        
        int time = 0;
        int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!q.isEmpty() && fresh > 0)
        {
            int size = q.size();
            for(int k = 0 ; k < size ; k++)
            {
            pair curr = q.poll();
            
            for(int i = 0 ; i < dir.length ; i++)
            {
                int nr = curr.r + dir[i][0];
                int nc = curr.c + dir[i][1];
                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1)
                {
                    grid[nr][nc] = 2;
                    q.offer(new pair(nr,nc));
                    fresh--;
                }
            }
            }
            time++;
        }
        
        if(fresh == 0 )
        {
            return time;
        }
        
        return -1;
        
    }
}