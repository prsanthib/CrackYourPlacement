// Find paths from corner cell to middle cell in maze
class ctomid
{
    public static void findallPaths(int[][] maze , int r , int c)
    {
        
    }

    public static void main(String args[])
    {
        int[][] maze = { { 3, 5, 4, 4, 7, 3, 4, 6, 3 },
                         { 6, 7, 5, 6, 6, 2, 6, 6, 2 },
                         { 3, 3, 4, 3, 2, 5, 4, 7, 2 },
                         { 6, 5, 5, 1, 2, 3, 6, 5, 6 },
                         { 3, 3, 4, 3, 0, 1, 4, 3, 4 },
                         { 3, 5, 4, 3, 2, 2, 3, 3, 5 },
                         { 3, 5, 4, 3, 2, 6, 4, 4, 3 },
                         { 3, 5, 1, 3, 7, 5, 3, 6, 4 },
                         { 6, 2, 4, 3, 4, 5, 4, 5, 1 } };

        findallPaths(maze , 0 , 0);
    }
}