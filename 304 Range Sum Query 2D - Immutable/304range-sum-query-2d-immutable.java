class NumMatrix {
    // private int matrix[][];
    private int[][] sumMat;
    public NumMatrix(int[][] matrix) {
        // this.matrix = matrix;
        int ROWS = matrix.length, COLS = matrix[0].length;
        sumMat = new int[ROWS+1][COLS+1];

        for(int r = 0;r<ROWS;r++){
            int prefix =0;
            for(int c=0;c<COLS;c++){
                prefix += matrix[r][c];
                int above = sumMat[r][c+1];
                sumMat[r+1][c+1] = prefix + above;
            }
        }
    }
    // Brute Force Solution
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // int res=0;
        // for(int i=row1;i<=row2;i++){
        //     for(int j=col1;j<=col2;j++){
        //         res+=matrix[i][j];
        //     }
        // }
        row1++;col1++;row2++;col2++;
        int bottomRight = sumMat[row2][col2];
        int above = sumMat[row1-1][col2];
        int left = sumMat[row2][col1-1];
        int topLeft = sumMat[row1-1][col1-1];
        return bottomRight-above-left+topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */