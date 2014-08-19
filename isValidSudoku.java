public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) return false;
        boolean[] used = new boolean[9];

        for (int i = 0; i < 9; i++) {
            Arrays.fill(used, false);
            // check rows
            for (int j = 0; j < 9; j++) {
                if (!check(board, i, j, used))
                    return false;
            }

            Arrays.fill(used, false);
            // check cols
            for (int j = 0; j < 9; j++) {
                if (!check(board, j, i, used))
                    return false;
            }            
        }


        // check blocks
        for (int c = 0; c < 3; c++) {
            for (int r = 0; r < 3; r++) {
                Arrays.fill(used, false);
                for (int i = 3 * c; i < 3 * c + 3; i++)
                    for (int j = 3 * r; j < 3 * r + 3; j++)
                        if (!check(board, i, j, used))
                            return false;
            }
        }

        return true;
    }

    boolean check(char[][] board, int x, int y, boolean[] used) {
        if (board[x][y] == '.') return true;
        if (used[board[x][y] - '1'] == true) return false;

        return used[board[x][y] - '1'] = true;
    }
}