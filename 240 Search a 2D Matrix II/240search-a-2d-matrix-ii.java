class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // finding out the pivot points in each row 
        // checking last element and first element of two different rows
        // won't work
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = n - 1;
        while(row < m && col >= 0){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) {
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
}