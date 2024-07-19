class Solution {

    public static boolean issafe(char[][] board , int r ,int c , char p)
    {
        for(int k = 0 ; k < 9 ; k++)
        {
            if(board[r][k] == p)
            {
                return false;
            } 
            if(board[k][c] == p)
            {
                return false;
            } 
        }

        //grid
        int row = (r/3)*3;
        int col = (c/3)*3;

        for(int i = row ; i < row+3 ; i++)
        {
            for(int j = col ; j < col+3 ; j++)
            {
                if(board[i][j] == p)
                {
                    return false;
                }
            }
        }

        return true;

    } 

    public static boolean sudoku(char[][] board , int r ,int c)
    {
        if(r == 9 && c == 0)
        {
            return true;
        }

        int nc = c+1;
        int nr = r;

        if(nc == 9)
        {
            nr = r+1;
            nc = 0;
        }

        if(board[r][c] != '.')
        {
            return sudoku(board,nr,nc);
        }

        for(char i = '1' ; i <= '9' ; i++)
        {
            if(issafe(board,r,c,i))
            {
                board[r][c] = i;
                if(sudoku(board,nr,nc))
                {
                    return true;
                }
                board[r][c] = '.';
            }
        }
        
        return false;
    }
    public void solveSudoku(char[][] board) {
        
         sudoku(board,0,0);
    }
}