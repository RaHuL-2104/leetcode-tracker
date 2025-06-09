class Solution {
    public int longestStrChain(String[] words) {
        // Similar to LIS question 
        // Two things extra : sort based on the length 
        // Add a function to check the predecessor 
        // Bottom Up Approach
        int n = words.length;
        Arrays.sort(words,(s1,s2) -> Integer.compare(s1.length(),s2.length()));
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxL = 1;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                if(predecessor(words[j], words[i])){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    maxL = Math.max(maxL, dp[i]);
                }
            }
        }
        return maxL;
    }
    public boolean predecessor(String prev, String curr){
        int M = prev.length();
        int N = curr.length();
        if(M >=N || N-M != 1){
            return false;
        }
        int i = 0,j = 0;
        while(i < M && j < N){
            if(prev.charAt(i) == curr.charAt(j)){
                i++;
            }
            j++;
        }
        return i == M;
    }
     
}

/* Recursion + memo
    int n;
    int[][] t = new int[1001][1001];
      public boolean predecessor(String prev, String curr){
        int M = prev.length();
        int N = curr.length();
        if(M >=N || N-M != 1){
            return false;
        }
        int i = 0,j = 0;
        while(i < M && j < N){
            if(prev.charAt(i) == curr.charAt(j)){
                i++;
            }
            j++;
        }
        return i == M;
    }
    int lis(String[] words, int prevIdx, int currIdx){
        if(currIdx == n) return 0;
        if(prevIdx != -1 && t[prevIdx][currIdx] != -1)
            return t[prevIdx][currIdx];
        int taken = 0;
        if(prevIdx == -1 || predecessor(words[prevIdx],words[currIdx]))
            taken = 1 + lis(words,currIdx,currIdx+1);
        int notTaken = lis(words, prevIdx, currIdx+1);
        if(prevIdx != -1){
            t[prevIdx][currIdx] = Math.max(taken, notTaken);
        }
        return Math.max(taken,notTaken);
    }
    int longestStrChain(String[] words){
        for(int i = 0; i<1000;i++){
            for(int j = 0l j< 1000;j++){
                t[i][j] = -1;
            }
        }
        n = words.length;
        Arrays.sort(words, (s1,s2) -> Integer.compare(s1.length(), s2.length()));
        return lis(words, -1, 0);
    }
 */