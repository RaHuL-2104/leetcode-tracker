class Solution {
    private long[][][] ways;
    private final int MOD = 1000000007;
    public int numOfArrays(int n, int m, int k) {
        ways = new long[52][102][52];
        for(int j = 1;j <= m ;j++){
            ways[1][j][1] = 1;
        }
        for(int a = 1;a <= n;a++){
            for(int b = 1;b <= m; b++){
                for(int c = 1; c <= k; c++){
                    long s = 0;

                    s=(s+b * ways[a-1][b][c]) % MOD;
                    for(int x = 1; x < b; x++){
                        s = (s + ways[a-1][x][c-1]) % MOD;
                    }
                    ways[a][b][c] = (ways[a][b][c] + s) % MOD;
                }
            }
        }
        long ans = 0;
        for(int j = 1; j <= m; j++){
            ans = (ans + ways[n][j][k]) % MOD;
        }
        return (int) ans;
    }
}

/** Recursion + Memoization Approach
    private int N,M,K;
    private final int MOD = 1000000007;
    private int[][][] t;
    public int numOfArrays(int n, int m, int k){
        N = n;
        M = m;
        K = k;
        t = new int[51][51][101];
        for(int i = 0; i < 51; i++){
            for(int j = 0; j < 51; j++){
                Arrays.fill(t[i][j], -1)
            }
        }
        return solve(0,0,0);
    }
    private int solve(int idx, int searchCost, int maxSoFar){
        if(idx == N){
            if(searchCost == K){
                return 1;
            }
            return 0;
        }
        if(t[idx][searchCost][maxSoFar] != -1){
            return t[idx][searchCost][maxSoFar];
        }
        int result = 0;
        for(int i = 1; i <= M; i++){
            if(i > maxSoFar){
                result = (result + solvw(idx + 1,searchCost + 1,i)) % MOD;
            } else{
                result = (result + solve(idx + 1, searchCost, maxSoFar)) % MOD;
            }
        }
        return t[idx][searchCost][maxSoFar] = result % MOD;
    }
 */