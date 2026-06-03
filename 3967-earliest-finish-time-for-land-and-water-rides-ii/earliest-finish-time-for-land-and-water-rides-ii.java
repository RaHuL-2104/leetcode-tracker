class Solution {
    private int finishTimes(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration){
        int finish1 = Integer.MAX_VALUE;
        for(int i = 0; i < landStartTime.length; i++){
            finish1 = Math.min(finish1, landStartTime[i] + landDuration[i]); 
        }

        int finish2 = Integer.MAX_VALUE;
        for(int i = 0; i < waterStartTime.length; i++){
            finish2 = Math.min(finish2, Math.max(finish1, waterStartTime[i]) + waterDuration[i]);
        }

        return finish2;
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int land = finishTimes(landStartTime, landDuration, waterStartTime, waterDuration);
        int water = finishTimes(waterStartTime, waterDuration, landStartTime, landDuration);
        return Math.min(land, water);
    }
}