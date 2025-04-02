class Solution {
    public int minCost(String colors, int[] neededTime) {
        char[] x = colors.toCharArray();
        int n = x.length;
        int time = 0;
        int prevMax = 0;
        for(int i = 0; i < n ; i++){
            if(i > 0 && x[i] != x[i-1]){
                prevMax = 0;
            }
            int curr = neededTime[i];
            time += Math.min(prevMax, curr);
            prevMax = Math.max(prevMax, curr);
        }
        return time;
    }
}