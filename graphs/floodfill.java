class Solution {

    public static boolean issafe(int [][]temp , int r ,int c , int c1 , boolean [][] visited)
    {
        return r >= 0 && c >= 0 && r < temp.length && c < temp[0].length && temp[r][c] == c1 && !visited[r][c];
    }

    public static void fill(int [][]temp , int r ,int c , int c1 , int c2 , boolean visited[][])
    {
        temp[r][c] = c2;
        visited[r][c] = true;
        if(issafe(temp,r+1,c,c1,visited))  
        {
            fill(temp,r+1,c,c1,c2,visited);
        }
        if(issafe(temp,r-1,c,c1,visited))
        {
            fill(temp,r-1,c,c1,c2,visited);
        }
        if(issafe(temp,r,c+1,c1,visited))
        {
            fill(temp,r,c+1,c1,c2,visited);
        }
        if(issafe(temp,r,c-1,c1,visited))
        {
            fill(temp,r,c-1,c1,c2,visited);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int c1 = image[sr][sc];
        boolean visited[][] = new boolean[image.length][image[0].length];
        fill(image,sr,sc,c1,color,visited);
        return image;
    }
}