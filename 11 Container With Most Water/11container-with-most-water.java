class Solution {
    public int maxArea(int[] height) {
        // Finding max height and width to find the max Area
        int left = 0;
        int right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while(left < right){
            int width = right - left;
            int area = Math.min(height[left], height[right])*width;
            maxArea = Math.max(maxArea, area);
            if(height[left] <= height[right]){
                left++;
            } else{
                right--;
            }
        }
        return maxArea;
    }
}