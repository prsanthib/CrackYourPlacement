class Solution {
    public int countArrangement(int n) {
         boolean[] visited = new boolean[n + 1];
        return backtrack(1, n, visited);
    }

     private int backtrack(int pos, int n, boolean[] visited) {
        if (pos > n) {
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                visited[i] = true;
                count += backtrack(pos + 1, n, visited);
                visited[i] = false;   
            }
        }

        return count;
    }
}