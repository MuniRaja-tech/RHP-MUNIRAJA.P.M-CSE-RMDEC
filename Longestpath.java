class Solution {

    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    int R, C;

    private int dfs(int[][] matrix, int row, int col, int[][] dp) {

        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int maxLen = 1;

        for (int[] d : dir) {

            int nr = row + d[0];
            int nc = col + d[1];

            if (nr >= 0 && nr < R &&
                nc >= 0 && nc < C &&
                matrix[nr][nc] > matrix[row][col]) {

                maxLen = Math.max(
                    maxLen,
                    1 + dfs(matrix, nr, nc, dp)
                );
            }
        }

        return dp[row][col] = maxLen;
    }

    public int longestIncreasingPath(int[][] matrix) {

        R = matrix.length;
        C = matrix[0].length;

        int[][] dp = new int[R][C];
        int ans = 0;

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                ans = Math.max(ans, dfs(matrix, row, col, dp));
            }
        }

        return ans;
    }
}