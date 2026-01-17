class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // take the 2D array row wise and apply binary search on every row
        // for(int[] row : matrix){
        //     int low = 0, high = row.length - 1;
        //     while(low <= high){
        //         int mid = low + (high-low)/2;
        //         if(row[mid] == target) return true;
        //         if(target < row[mid]){
        //             high = mid - 1;
        //         } else{
        //             low = mid + 1;
        //         }
        //     }
        // }
        // return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m*n - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int row = mid/n;
            int col = mid%n;
            if(target == matrix[row][col]) return true;
            else if(target < matrix[row][col]) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}