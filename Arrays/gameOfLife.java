class Solution {
    public static int livecells(int[][] board , int r , int c)
    {
        int c1 = 0;
        if(r-1 >= 0 && board[r-1][c] == 1)
        {
            c1++;
        }
        if(c-1 >= 0 && board[r][c-1] == 1)
        {
            c1++;
        }
        if(c+1 < board[0].length && board[r][c+1] == 1)
        {
            c1++;
        }
        if(r+1 < board.length && board[r+1][c] == 1)
        {
            c1++;
        }
        if(r-1 >= 0 && c-1>=0 && board[r-1][c-1] == 1)
        {
            c1++;
        }
        if(r-1 >= 0 && c+1 < board[0].length && board[r-1][c+1] == 1)
        {
            c1++;
        }
        if(r+1 < board.length && c-1 >= 0 && board[r+1][c-1] == 1)
        {
            c1++;
        }
        if(r+1 < board.length && c+1<board[0].length && board[r+1][c+1] == 1)
        {
            c1++;
        }


        return c1;
    }

    public void gameOfLife(int[][] board) {
        int[][] temp = new int[board.length][board[0].length];

        for(int i = 0 ; i < board.length ; i++)
        {
            for(int j = 0 ; j < board[0].length ; j++)
            {
                int lc = livecells(board,i,j);
                System.out.print(lc+" ");
                if(board[i][j] == 1)
                {
                    if(lc == 2 || lc == 3)
                    {
                        temp[i][j] = 1;
                        continue;
                    }
                    else if(lc < 2 || lc > 3)
                    {
                        
                        temp[i][j] = 0;
                    }
                }
                else
                {
                    if(lc == 3)
                    {
                        temp[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 0 ; i < temp.length ; i++)
        {
            for(int j = 0 ; j < temp[0].length ; j++)
            {
                board[i][j] = temp[i][j];
            }
        }

    }
}