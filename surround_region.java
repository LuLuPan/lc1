public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if (m <= 2) return;
        int n = board[0].length;
        if (n <= 2) return;

        // find 'O' on edge
        Queue<Integer> edged = new LinkedList<Integer>();
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n -1) &&
                     board[i][j] == 'O')
                    edged.add(i * n + j);
            }
        }

        // find all 'O' connect with 'O' on edge
        while (!edged.isEmpty()) {
            int pos = edged.poll();
            int x = pos / n;
            int y = pos % n;

            if (board[x][y] == 'E')
                continue;
            board[x][y] = 'E';
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (((x + i) >= 0 && (x + i) <= m - 1 &&
                        (y + j) >= 0 && (y + j) <= n - 1) && 
                        (i == 0 || j == 0) &&
                        board[x + i][y + j] == 'O')
                    {
                        edged.add((x + i) * n + y + j);
                    }
                }
            }
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'E')
                    board[i][j] = 'O';         
    }
}