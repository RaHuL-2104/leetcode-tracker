class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int n : nums){
            mp.put(n, mp.getOrDefault(n, 0) + 1);
        }
        int currentMax = 0;
        int res = 0;
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            if(entry.getValue() > currentMax){
                currentMax = entry.getValue();
                res = entry.getValue();
            } else if(entry.getValue() == currentMax){
                res += entry.getValue();
            }
        }
        return res;
    }
}