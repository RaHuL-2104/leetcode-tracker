class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int M = obstacleGrid.length, N = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[M-1][N-1] == 1){
            return 0;
        }
        obstacleGrid[M-1][N-1] = 1;
        for(int r = M-1; r >= 0; r--){
            for(int c = N-1; c >= 0; c--){
                if(r == M-1 && c == N-1){
                    continue;
                }
                if(obstacleGrid[r][c] == 1){
                    obstacleGrid[r][c] = 0;
                } else{
                    int down = (r + 1 < M) ? obstacleGrid[r+1][c] : 0;
                    int right = (c + 1 < N) ? obstacleGrid[r][c+1] : 0;
                    obstacleGrid[r][c] = down + right;
                }
            }
        }
        return obstacleGrid[0][0];
    }
}

//Top-Down Approach
/**
private int[][] dp;
public int uniquePathsWithObstacles(int[][] grid){
    int M = groid.length, N = grid[0].length;
    dp = new int[M][N];
    for(int i = 0; i < M; i++){
        for(int j = 0; j < N; j++){
            dp[i][j] = -1;
        }
    }
    return dfs(0,0,grid,M,N);
}
private int dfs(int r, int c,int[][] grid, int M, int N){
    if(r == M || c == N || grid[r][c] == 1){
        return 0;
    }
    if(r == M - 1 && c == N - 1){
        return 1;
    }
    if(dp[r][c] != -1){
        return dp[r][c];
    }
    dp[r][c] = dfs(r+1, c, grid, M, N) + dfs(r, c+1, grid, M, N);
    return dp[r][c];
}
 */