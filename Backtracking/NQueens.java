class Solution {

    static List<List<String>> res = new ArrayList<>();
    static List<String> al = new ArrayList<>();

    public static boolean issafe(char mat[][] , int r , int c)
    {
        //up
        for(int i = 0 ; i < r ; i++)
        {
            if(mat[i][c] == 'Q')
            {
                return false;
            }
        }
        
        int i = r;
        int j = c;
        while(i >= 0 && j >= 0)
        {
            if(mat[i][j] == 'Q')
            {
                return false;
            }
            i--;
            j--;
        }

        i = r;
        j = c;
        while(i >= 0 && j < mat[0].length)
        {
            if(mat[i][j] == 'Q')
            {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    public static void addsol(char mat[][])
    {
        al.clear();
        for(int i = 0 ; i < mat.length ; i++)
        {
            String str = "";
            for(int j = 0 ; j < mat.length ; j++)
            {
                if(mat[i][j] == 'Q')
                {
                    str += "Q";
                }
                else
                {
                    str += ".";
                }
            }
            al.add(str);
        }
        res.add(new ArrayList<>(al));
    }
    public static void util(char[][] mat , int r)
    {
        if(r == mat.length)
        {
            addsol(mat);
            return ;
        }

        for(int i = 0 ; i < mat.length ; i++)
        {
            if(issafe(mat,r,i))
            {
                mat[r][i] = 'Q';
                util(mat,r+1);
                mat[r][i] = '.';
            }
        }

    }
    public List<List<String>> solveNQueens(int n) {
        res.clear();
        char mat[][] = new char[n][n];
        for(int i = 0 ; i < n ; i++)
        {
            Arrays.fill(mat[0] , '.');
        }

        util(mat,0);

        return res;
    }
}