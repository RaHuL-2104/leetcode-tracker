class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] prefixSum = new int[rows][cols];
        // prefix[i][j] = Sum of all elements in mat from top_left[0][0] to [i][j]

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                prefixSum[i][j] = (i > 0 ? prefixSum[i-1][j] : 0) + (j > 0 ? prefixSum[i][j-1] : 0) - ((i > 0 && j > 0)? prefixSum[i-1][j-1]: 0) + mat[i][j];
            }
        }

        int bestSideSquare = 0;  // maximum side of the square
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                for(int offset = bestSideSquare; offset < Math.min(rows - i, cols - j); offset++){
                    int r2 = i + offset;
                    int c2 = j + offset;

                    int sum = prefixSum[r2][c2];
                    if (i > 0) sum -= prefixSum[i-1][c2];
                    if( j > 0) sum -= prefixSum[r2][j-1];
                    if(i > 0 && j > 0) sum += prefixSum[i-1][j-1];
                    if(sum <= threshold){
                        bestSideSquare = offset + 1;
                    } else{
                        break;
                    }
                }
            }
        }
        return bestSideSquare;
    }
}