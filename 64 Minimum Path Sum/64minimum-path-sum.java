class Solution {
    public int minPathSum(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int[] dp = new int[COLS + 1];
        for(int c = 0; c <= COLS; c++){
            dp[c] = Integer.MAX_VALUE;
        }
        dp[COLS - 1] = 0;

        for(int r = ROWS - 1; r >= 0; r--){
            for(int c = COLS - 1; c >= 0; c--){
                dp[c] = grid[r][c] + Math.min(dp[c], dp[c+1]);
            }
        }
        return dp[0];
    }
}

/** Top-Down Approach
    private int[][] dp;
    public int minPathSum(int[][] grid){
        int m = grid.length, n = grid[0].length;
        dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return dfs(0,0,grid);
    }
    public int dfs(int r, int c, int[][] grid){
        if(r == grid.length - 1 && c == grid[0].length - 1){
            return grid[r][c]
        }
        if(r == grid.length || c == grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(dp[r][c] != -1){
            return dp[r][c];
        }

        dp[r][c] = grid[r][c] + Math.min(dfs(r+1, c, grid), dfs(r, c+1, grid));
        return dp[r][c];
    }
 */