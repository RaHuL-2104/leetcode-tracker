class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int res = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int land = landStartTime[i] + landDuration[i];
                int first = Math.max(land, waterStartTime[j]) + waterDuration[j];
                res = Math.min(res, first);

                int water = waterStartTime[j] + waterDuration[j];
                int second = Math.max(water, landStartTime[i]) + landDuration[i];
                res = Math.min(res, second);
            }
        }
        return res;
    }
}