class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int n : nums){
            mp.put(n,mp.getOrDefault(n,0) + 1);
        }
        for(Map.Entry<Integer, Integer> e : mp.entrySet()){
            if(e.getValue() == 2){
                res.add(e.getKey());
            }
        }
        return res;
    }
}