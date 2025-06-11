class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // Bottom-Up
        int m = text1.length();
        int n = text2.length();

        int[][] t = new int[2][n+1];
        for(int i = 0; i < m+1; i++){
            for(int j = 0; j < n+1; j++){
                if(i == 0 || j == 0){
                    t[i%2][j] = 0;
                }else if (text1.charAt(i-1) == text2.charAt(j-1)){
                    t[i%2][j] = 1 + t[(i+1) % 2][j - 1];
                }else{
                    t[i%2][j] = Math.max(t[i%2][j-1], t[(i + 1)%2][j]);
                }
            }
        }
        return t[m%2][n];
    }
}

/** Recursion + Memoization
    private int[][] t;
    public int LCS(String s1, String s2, int m , int n){
        if(m == 0 || n == 0)
            return t[m][n] = 0;
        if(t[m][n] != -1)
            return t[m][n];
        if(s.charAt(m - 1) == s.charAt(n -1))
            returnn t[m][n] = 1+ LCS(s1, s2, m-1, n-1);
        return t[m][n] = Math.max(LCS(s1,s2,m,n-1),LCS(s1,s2s,m-1,n));
    }
    public int longestCommonSubsequence(String text1, String text2){
        int m = text1.length();
        int n = text2.length();

        t = new int[m+1][n+1];
        for(int[] row : t){
            Arrays.fill(row, -1);
        }
        return LCS(text1,text2,m,n);
    }

 */