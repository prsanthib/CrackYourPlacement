class Solution {

    public static boolean issafe(char grid[][] ,int r , int c , boolean visit[][])
    {
        return r >= 0 && c >= 0 && r < visit.length && c < visit[0].length && visit[r][c] == false ;
    }

    public static void dfs(char[][] grid , int i , int j , boolean visit[][])
    {
        visit[i][j] = true;
        if(issafe(grid,i+1,j,visit))
        {
            dfs(grid,i+1,j,visit);
        }
        if(issafe(grid,i-1,j,visit))
        {
            dfs(grid,i-1,j,visit);
        }
        if(issafe(grid,i,j+1,visit))
        {
            dfs(grid,i,j+1,visit);
        }
        if(issafe(grid,i,j-1,visit))
        {
            dfs(grid,i,j-1,visit);
        }
    }
    public int numIslands(char[][] grid) {
        boolean visit[][] = new boolean[grid.length][grid[0].length];
        int count = 0;

        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[0].length ; j++)
            {
                if(grid[i][j] == '0')
                {
                    visit[i][j] = true;
                }
            }
        }

        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[0].length ; j++)
            {
                if(!visit[i][j])
                {
                    dfs(grid,i,j,visit);
                    count++;
                }
            }
        }

        return count;
    }
}