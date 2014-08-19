public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return false;
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (dfs(board, word, 0, i, j, visited))
                    return true;
        return false;
    }

    private boolean dfs(char[][] board, String word, int steps, int x, 
        int y, boolean[][] visited) {
        // convergence condition
        if (steps == word.length()) return true;

        // termination condition
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length)
            return false;
        if (visited[x][y]) return false;

        if (board[x][y] != word.charAt(steps)) return false;

        boolean ret = false;
       
        visited[x][y] = true;
        ret = dfs(board, word, steps + 1, x + 1, y, visited) ||
              dfs(board, word, steps + 1, x - 1, y, visited) ||
              dfs(board, word, steps + 1, x, y + 1, visited) ||
              dfs(board, word, steps + 1, x, y - 1, visited);
        visited[x][y] = false;
        return ret;
    }
}