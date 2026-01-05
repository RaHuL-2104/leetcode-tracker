class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int countNegatives = 0;
        int smallest = Integer.MAX_VALUE;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                sum += Math.abs(matrix[i][j]);
                countNegatives += matrix[i][j] < 0 ? 1:0;
                smallest = Math.min(smallest, Math.abs(matrix[i][j]));
            }
        }
        if(countNegatives % 2 == 0){
            return sum;
        }
        return sum - 2L*smallest;
    }
}