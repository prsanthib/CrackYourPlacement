class Solution {
    public void rotate(int[][] matrix) {
        //transpose and rotate
        int temp[][] = new int[matrix[0].length][matrix.length];
        for(int i = 0 ; i < matrix.length ; i++)
        {
            for(int j = 0 ; j < matrix[0].length ; j++)
            {
                temp[j][i] = matrix[i][j]; 
            }
        }

        //reverse every row
        for(int i = 0 ; i < temp.length ; i++)
        {
            for(int j = 0 ; j < (temp[0].length)/2 ; j++)
            {
                //reverse
                int s = temp[i][j];
                temp[i][j] = temp[i][temp[0].length-1-j];
                temp[i][temp[0].length-1-j] = s;
            }
        }

        for(int i = 0 ; i < matrix.length ; i++)
        {
            for(int j = 0 ; j < matrix[0].length ; j++)
            {
                matrix[i][j] = temp[i][j];
            }
        }
    }
}