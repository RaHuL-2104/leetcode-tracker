class Solution {
    int m,n;
    public int kthSmallest(int[][] matrix, int k) {
        // Flatten the array in 1D and sort it. Since all the elements are sorted so the kth smallest element would appear at (k-1)th index
        // int totalElements = 0;
        // for(int[] row : matrix){
        //     totalElements += row.length;
        // }
        // int[] oneD = new int[totalElements];
        // int index = 0;
        // for(int[] row : matrix){
        //     for(int element : row){
        //         oneD[index++] = element;
        //     }
        // }
        // Arrays.sort(oneD);
        // return oneD[k-1];
        m = matrix.length;
        n = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[m-1][n-1];
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(countLessOrEqual(matrix, mid) >= k){
                ans = mid;
                high = mid - 1;
            }else low = mid + 1;
        }
        return ans;
    }
    private int countLessOrEqual(int[][] matrix, int x){
        int count = 0, c = n - 1;
        for(int r = 0; r < m; ++r){
            while(c>=0 && matrix[r][c] > x) --c;
            count += (c+1);
        }
        return count;
    }
}