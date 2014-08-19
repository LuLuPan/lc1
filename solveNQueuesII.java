public class Solution {
    public int totalNQueens(int n) {
        if (n == 0 || n == 2 || n == 3) return 0;
        int[] A = new int[n];
        int[] sol_count = new int[1];
        Arrays.fill(A, -1);
        dfs(A, 0, sol_count);
        return sol_count[0];
    }

    private boolean isValidPos(int[] A, int col, int row) {
        for (int i = 0; i < row; i++) {
            if (A[i] == col || Math.abs(A[i] - col) == (row - i))
                return false;
        }

        return true;
    } 

    private void dfs(int[] A, int row, int[] sol_count) {
        int n = A.length;
        if (row == n) {
            sol_count[0]++;
            return;
        }

        // for each col
        for (int i = 0; i < n; i++) {
            if (isValidPos(A, i, row)) {
                A[row] = i;
                dfs(A, row + 1, sol_count);
                A[row] = 0;
            }
        }
    }
}