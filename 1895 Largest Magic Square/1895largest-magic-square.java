class Solution {
    public int largestMagicSquare(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Row-wise prefix sum
        int[][] rowPrefixSum = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            rowPrefixSum[i][0] = grid[i][0];
            for(int j = 1; j < cols; j++){
                rowPrefixSum[i][j] = rowPrefixSum[i][j-1] + grid[i][j];
            }
        }

        // Column-wise prefix sum
        int[][] colPrefixSum = new int[rows][cols];
        for(int j = 0; j < cols; j++){
            colPrefixSum[0][j] = grid[0][j];
            for(int i = 1; i < rows; i++){
                colPrefixSum[i][j] = colPrefixSum[i - 1][j] + grid[i][j];
            }
        }

        // Trying square sizes from the largest to smallest
        for(int side = Math.min(rows, cols); side >= 2; side--){

            //Top-left corner of square
            for(int i = 0; i + side - 1 < rows; i++){
                for(int j = 0; j + side - 1 < cols; j++){
                    int targetSum = rowPrefixSum[i][j + side - 1] - (j > 0 ? rowPrefixSum[i][j - 1] : 0);
                    boolean allSame = true;

                    //Check all rows
                    for(int r = i + 1; r < i + side; r++){
                        int rowSum = rowPrefixSum[r][j + side - 1] - (j > 0 ? rowPrefixSum[r][j - 1] : 0);
                        if(rowSum != targetSum){
                            allSame = false;
                            break;
                        }
                    }
                    if(!allSame) continue;

                    // Check all columns
                    for(int c = j; c < j + side; c++){
                        int colSum = colPrefixSum[i + side - 1][c] - (i > 0 ? colPrefixSum[i-1][c] : 0);
                        if(colSum != targetSum){
                            allSame = false;
                            break;
                        }
                    }
                    if(!allSame) continue;

                    // Check diagonals
                    int diag = 0;
                    int antiDiag = 0;
                    for(int k = 0; k < side; k++){
                        diag += grid[i + k][j + k];
                        antiDiag += grid[i + k][j + side - 1 - k];
                    }
                    if(diag == targetSum && antiDiag == targetSum){
                        return side;
                    }
                }
            }
        }
        return 1;
    }
}