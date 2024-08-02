class ctomid {
    static int row[] = {1, 0, -1, 0};
    static int col[] = {0, 1, 0, -1};

    public static void findallPaths(int[][] maze, int r, int c, String str, boolean[][] visit) {
        if (r >= maze.length || r < 0 || c >= maze[0].length || c < 0 || visit[r][c]) {
            return;
        }

        str += "(" + r + ", " + c + ") -> ";
        int n = maze[r][c];
        visit[r][c] = true;

        if (r == maze.length / 2 && c == maze[0].length / 2) {
            str += "MID";
            System.out.println(str);
            visit[r][c] = false;
            return;
        }

        for (int i = 0; i < 4; i++) {
            findallPaths(maze, r + (row[i] * n), c + (col[i] * n), str, visit);
        }

        visit[r][c] = false;
    }

    public static void main(String args[]) {
        int[][] maze = { 
            { 3, 5, 4, 4, 7, 3, 4, 6, 3 },
            { 6, 7, 5, 6, 6, 2, 6, 6, 2 },
            { 3, 3, 4, 3, 2, 5, 4, 7, 2 },
            { 6, 5, 5, 1, 2, 3, 6, 5, 6 },
            { 3, 3, 4, 3, 0, 1, 4, 3, 4 },
            { 3, 5, 4, 3, 2, 2, 3, 3, 5 },
            { 3, 5, 4, 3, 2, 6, 4, 4, 3 },
            { 3, 5, 1, 3, 7, 5, 3, 6, 4 },
            { 6, 2, 4, 3, 4, 5, 4, 5, 1 } 
        };

        boolean[][] visit = new boolean[maze.length][maze[0].length];
        findallPaths(maze, 0, 0, "", visit);
    }
}
