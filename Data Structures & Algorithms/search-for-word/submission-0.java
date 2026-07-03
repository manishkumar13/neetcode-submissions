class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // Try every cell as a starting point
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Start DFS only if the first character matches
                if (board[row][col] == word.charAt(0) && dfs(board, word, row, col, 0)) {
                    return true;
                }
            }
        }

        // Word cannot be formed
        return false;
    }

    /**
     * Performs DFS to check if the word can be formed starting
     * from board[row][col].
     *
     * @param row   Current row
     * @param col   Current column
     * @param index Current character index in the word
     */
    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        // Base case: all characters have been matched
        if (index == word.length()) {
            return true;
        }

        // Out of bounds
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        // Character mismatch or cell already visited
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Save the original character
        char temp = board[row][col];

        // Mark current cell as visited
        board[row][col] = '#';

        // Explore all four directions
        boolean found = dfs(board, word, row + 1, col, index + 1) || // Down
            dfs(board, word, row - 1, col, index + 1) || // Up
            dfs(board, word, row, col + 1, index + 1) || // Right
            dfs(board, word, row, col - 1, index + 1); // Left

        // Restore the original character (Backtracking)
        board[row][col] = temp;

        return found;
    }
}