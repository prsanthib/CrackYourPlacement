class Solution {

    public static int histArea(int[] arr)
    {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < arr.length)
        {
            if(stack.isEmpty() || arr[i] >= arr[stack.peek()])
            {
                stack.push(i++);
            }
            else
            {
                int ht = arr[stack.pop()];
                int wt = stack.isEmpty() ? i : i-stack.peek()-1;
                maxArea = Math.max(maxArea , ht*wt);
            }
        }

        while (!stack.isEmpty()) {
            int height = arr[stack.pop()];
            int width = stack.isEmpty() ? i : i-stack.peek()-1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    public static int util(char[][] mat)
    {
        int[] arr = new int[mat[0].length];

        int maxArea = 0;

        for(int i = 0 ; i < mat[0].length ; i++)
        {
            arr[i] = mat[0][i]-'0';
        }

        maxArea = Math.max(maxArea,histArea(arr));

        for(int i = 1 ; i < mat.length ; i++)
        {
            for(int j = 0 ; j < mat[0].length ; j++)
            {
                if(mat[i][j] == '0')
                {
                    arr[j] = 0;
                }
                else
                { 
                    arr[j] += mat[i][j]-'0';
                }
            }

            maxArea =  Math.max(maxArea , histArea(arr));
        }

        return maxArea;
    } 

    public int maximalRectangle(char[][] matrix) {
        return util(matrix);
    }
}