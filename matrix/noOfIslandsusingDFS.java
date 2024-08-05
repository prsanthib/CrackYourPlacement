class noOfIslandsusingDFS
{
    public static void dfs(int mat[][] , int r , int c)
    {
        if(r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || mat[r][c] == 0)
        {
            return;
        }

        mat[r][c] = 0;

        dfs(mat , r+1 , c);
        dfs(mat , r , c+1);
        dfs(mat , r-1 , c);
        dfs(mat , r , c-1);
        dfs(mat , r-1 , c+1);
        dfs(mat , r-1 , c-1);
        dfs(mat , r+1 , c-1);
        dfs(mat , r+1 , c+1);


    }

    public static int islands(int mat[][])
    {
        int count = 0;
        boolean visited[][] = new boolean[mat.length][mat[0].length];

        for(int i = 0 ; i < mat.length ; i++)
        {
            for(int j = 0 ; j < mat[0].length ; j++)
            {
                if(mat[i][j] == 1 && !visited[i][j])
                {
                    count++;
                    visited[i][j] = true;
                    dfs(mat , i , j);
                }
            }
        }

        return count;
    }

    public static void main(String args[])
    {
        int mat[][] = {{1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 0}};

        System.out.println(islands(mat));
    }
}