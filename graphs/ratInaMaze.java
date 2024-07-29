class Solution {
    
    public static boolean issafe(int mat[][] , int r, int c)
    {
        return r >= 0 && c >= 0 && r < mat.length && c < mat[0].length && mat[r][c] == 1;
    }
    public static void path(int mat[][] , ArrayList<String> al , int  r , int c , String str)
    {
        if(r == mat.length-1 && c == mat.length-1)
        {
            al.add(str);
            return ;
        }
        
        mat[r][c] = 0;
        if(issafe(mat,r+1,c))
        {
            // mat[r+1][c] = 0;
            path(mat,al,r+1,c,str+"D");
            // mat[r+1][c] = 1;
        }
        if(issafe(mat,r,c+1))
        {
            // mat[r][c+1] = 0;
            path(mat,al,r,c+1,str+"R");
            // mat[r][c+1] = 1;
        }
         if(issafe(mat,r-1,c))
        {
            // mat[r-1][c] = 0;
            path(mat,al,r-1,c,str+"U");
            // mat[r-1][c] = 1;
        }
        if(issafe(mat,r,c-1))
        {
            // mat[r][c-1] = 0;
            path(mat,al,r,c-1,str+"L");
            // mat[r][c-1] = 1;
        }
        
        mat[r][c] = 1;
    }
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        
        ArrayList<String> al = new ArrayList<>();
        if(mat[0][0] == 0)
        {
            return al;   
        }
        path(mat,al,0,0,"");
        return al;
    }
}