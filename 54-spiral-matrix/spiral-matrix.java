class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int id = 0;
        while(top <= bottom && left <= right){
            if(id == 0){
                for(int i = left; i <= right; i++){
                    res.add(matrix[top][i]);
                }
                top++;
            }
            if(id == 1){
                for(int i = top; i <= bottom; i++){
                    res.add(matrix[i][right]);
                }
                right--;
            }
            if(id == 2){
                for(int i = right; i >= left; i--){
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(id == 3){
                for(int i = bottom; i >= top; i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
            id = (id+1)%4;
        }
        return res;
    }
}