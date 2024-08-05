import java.util.Stack;

public class maxAreaRectangle1 {

    public static int maxHistogramArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int index = 0;
        
        while (index < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[index]) {
                stack.push(index++);
            } else {
                int topOfStack = stack.pop();
                int area = heights[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        
        while (!stack.isEmpty()) {
            int topOfStack = stack.pop();
            int area = heights[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }

    public static int maxRectangle(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int maxArea = 0;
        int[] height = new int[matrix[0].length];
        
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 0) {
                    height[i] = 0;
                } else {
                    height[i] += row[i];
                }
            }
            maxArea = Math.max(maxArea, maxHistogramArea(height));
        }
        
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 0, 1, 0, 0},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0}
        };

        System.out.println("Maximum size rectangle binary sub-matrix with all 1s: " + maxRectangle(matrix));
    }
}
