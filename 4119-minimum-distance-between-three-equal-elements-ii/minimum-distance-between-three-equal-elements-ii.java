class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> mp = new HashMap<>();
        int result = n;
        for(int k = 0; k < n; k++){
            mp.putIfAbsent(nums[k], new ArrayList<>());
            mp.get(nums[k]).add(k);
            if(mp.get(nums[k]).size() >= 3){
                List<Integer> list = mp.get(nums[k]);
                int s = list.size();
                int i = list.get(s - 3);
                result = Math.min(result, k-i);
            }
        }
        return result >= n ? -1 : 2 * result;
    }
}