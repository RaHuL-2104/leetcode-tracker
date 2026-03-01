class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxCount = 0;
        int idx = 0;
        for(int i = 0; i < mat.length; i++){
            int countOnes = 0;
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1){
                    countOnes++;
                }
            }
            if(countOnes > maxCount){
                maxCount = countOnes;
                idx = i;
            }
        }
        return new int[]{idx, maxCount};
    }
}