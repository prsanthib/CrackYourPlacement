class ReplaceOX {

    private void dfs(char[][] mat, int r, int c) {
        if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || mat[r][c] != 'O') {
            return;
        }

        mat[r][c] = '-';

        dfs(mat, r + 1, c);
        dfs(mat, r - 1, c);
        dfs(mat, r, c + 1);
        dfs(mat, r, c - 1);
    }

    public void replaceSurrounded(char[][] mat) {
        if (mat == null || mat.length == 0) {
            return;
        }

        int rows = mat.length;
        int cols = mat[0].length;

        for (int i = 0; i < rows; i++) {
            if (mat[i][0] == 'O') {
                dfs(mat, i, 0);
            }
            if (mat[i][cols - 1] == 'O') {
                dfs(mat, i, cols - 1);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (mat[0][j] == 'O') {
                dfs(mat, 0, j);
            }
            if (mat[rows - 1][j] == 'O') {
                dfs(mat, rows - 1, j);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 'O') {
                    mat[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == '-') {
                    mat[i][j] = 'O';
                }
            }
        }
    }

    public void printMatrix(char[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ReplaceOX solution = new ReplaceOX();

        char[][] mat = {
            {'X', 'O', 'X', 'O', 'X', 'X'},
            {'X', 'O', 'X', 'X', 'O', 'X'},
            {'X', 'X', 'X', 'O', 'X', 'X'},
            {'O', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'O', 'X', 'O'},
            {'O', 'O', 'X', 'O', 'O', 'O'},
        };

        System.out.println("Original matrix:");
        solution.printMatrix(mat);

        solution.replaceSurrounded(mat);

        System.out.println("\nMatrix after replacing surrounded 'O's with 'X's:");
        solution.printMatrix(mat);
    }
}
