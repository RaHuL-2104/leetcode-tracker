class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        // Finding longest consecutive subarrays in both hBars and vBars
        // x vBars = x+1 width
        // y hBars = y+1 height
        // min(width, height) such that we get squares and not rectangles
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxConsecutiveHBars = 1;
        int maxConsecutiveVBars = 1;
        int currConsecutiveHBars = 1;
        for(int i = 1; i < hBars.length; i++){
            if(hBars[i] - hBars[i-1] == 1){
                currConsecutiveHBars++;
            }
            else{
                currConsecutiveHBars = 1;
            }
            maxConsecutiveHBars = Math.max(maxConsecutiveHBars, currConsecutiveHBars);
        }

        int currConsecutiveVBars = 1;
        for(int i = 1; i < vBars.length; i++){
            if(vBars[i] - vBars[i-1] == 1){
                currConsecutiveVBars++;
            } else{
                currConsecutiveVBars = 1;
            }
            maxConsecutiveVBars = Math.max(maxConsecutiveVBars, currConsecutiveVBars);
        }

        int side = Math.min(maxConsecutiveHBars, maxConsecutiveVBars) + 1;
        return side*side;
    }
}