class Solution {
    public static boolean isWord(char[][]board , String str , int i , int j , boolean visited[][])
    {
        if(str == "")
        {
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != str.charAt(0))
        {
            return false;
        }

        String s = str.length() > 1 ? str.substring(1,str.length()) : "";
        visited[i][j] = true;
        boolean flag = isWord(board,s,i+1,j,visited) || isWord(board,s,i-1,j,visited) || isWord(board,s,i,j+1,visited) || isWord(board,s,i,j-1,visited);

        visited[i][j] = false;

        return flag;

    }
    public boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length];

        for(int i = 0 ; i < board.length ; i++)
        {
            for(int j = 0 ; j < board[0].length ; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if(isWord(board,word,i,j,visited))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}