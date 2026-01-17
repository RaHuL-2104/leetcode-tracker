class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int maxQuality = -1;
        int[] result = new int[]{-1,-1};
        for(int[] t : towers){
            int distance = Math.abs(t[0] - center[0]) + Math.abs(t[1] - center[1]);
            if(distance <= radius){
                if(t[2] > maxQuality){
                    maxQuality = t[2];
                    result = new int[]{t[0], t[1]};
                } else if(t[2] == maxQuality){
                    if(t[0] < result[0] || (t[0] == result[0] && t[1] < result[1])){
                        result = new int[]{t[0], t[1]};
                    }
                }
            }
        }
        return result;
    }
}