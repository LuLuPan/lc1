public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        if (n == 0 || n == 2 || n == 3) return result;

        int[] A = new int[n];
        Arrays.fill(A, -1);
        dfs(A, 0, result);
        return result;
    }

    private boolean isValidPos(int[] A, int col, int row) {
        for (int i = 0; i < row; i++) {
            if (A[i] == col || (Math.abs(A[i] - col) == (row - i))) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int[] A, int row, List<String[]> result) {
        if (row == A.length) {
            char[] charArray = new char[A.length];
            Arrays.fill(charArray, '.');
            String tmp = new String(charArray);
            String[] solution = new String[A.length];
            // generate solution
            for (int i = 0; i < A.length; i++) {
                StringBuilder sb = new StringBuilder(tmp);
                sb.setCharAt(A[i], 'Q');
                solution[i] = sb.toString();
            }
            result.add(solution);
            return;
        }

        for (int j = 0; j < A.length; j++) {
            if (isValidPos(A, j, row)) {
                A[row] = j;
                dfs(A, row + 1, result);
                A[row] = 0;
            }
        }
    }
}