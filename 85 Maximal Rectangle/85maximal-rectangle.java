class Solution {

    // Finding Next Smaller element from the right
    public int[] NSR(int[] heights){
        Stack<Integer> s = new Stack<>();
        int n = heights.length;
        int pseudo_index = n;
        int[] right = new int[n];
        for(int i = n - 1; i>= 0; i--){
            if(s.empty()){
                right[i] = pseudo_index;
            }else{
                while(!s.empty() && heights[s.peek()] >= heights[i])
                    s.pop();
                if(s.empty())
                    right[i] = pseudo_index;
                else
                    right[i] = s.peek();
            }
            s.push(i);
        }
        return right;
    }

    // Next Smallest Element from the left
    public int[] NSL(int[] heights){
        Stack<Integer> s = new Stack<>();
        int n = heights.length;
        int pseudo_idx = -1;
        int[] left = new int[n];
        for(int i = 0; i < n; i++){
            if(s.empty()){
                left[i] = pseudo_idx;
            }
            else{
                while(!s.empty() && heights[s.peek()] >= heights[i])
                    s.pop();
                if(s.empty())
                    left[i] = pseudo_idx;
                else
                    left[i] = s.peek();
            }
            s.push(i);
        }
        return left;
    }
    
    public int MAH(int[] heights){
        int n = heights.length;
        int[] right = NSR(heights);
        int[] left = NSL(heights);
        int[] width = new int[n];
        for(int i = 0; i < n; i++){
            width[i] = right[i] - left[i] - 1;
        }
        int max_area = 0;

        for(int i = 0; i < n; i++){
            int a = width[i]*heights[i];
            if(max_area < a){
                max_area = a;
            }
        }
        return max_area;
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] height = new int[m];
        for(int i = 0; i < m; i++){
            height[i] = (matrix[0][i] == '1')? 1 : 0;
        }
        int maxA = MAH(height);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '0')
                    height[j] = 0;
                else
                    height[j] +=1;
            }
            maxA = Math.max(maxA, MAH(height));
        }
        return maxA;
    }
}