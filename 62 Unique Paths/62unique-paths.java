class Solution {
    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row,1);
        for(int i = 0; i < m-1; i++){
            int[] newRow = new int[n];
            Arrays.fill(newRow, 1);
            for(int j = n-2; j >= 0; j--){
                newRow[j] = newRow[j+1] + row[j];
            }
            row =  newRow;
        }
        return row[0];
    }
}

// Top-Down Approach (Recur + Memo)
/**
    int[][] memo;
    public int uniquePaths(int m, int n){
        memo = new int[m][n];
        for(int[] it:memo){
            Arrays.fill(it, -1);
        }
        return dfs(0,0,m,n);
    }
    public int dfs(int i, int j, int m, int n){
        if(i == (m-1) && j == (n-1)){
            return 1;
        }
        if(i >= m || i >= n) return 0;
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        return memo[i][j] = dfs(i,j+1,m,n) + dfs(i+1,j,m,n);
    }
 */