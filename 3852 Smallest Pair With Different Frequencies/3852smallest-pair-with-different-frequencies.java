class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int x : nums){
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        List<Integer> distinct = new ArrayList<>(mp.keySet());
        Collections.sort(distinct);
        for(int i = 0; i < distinct.size(); i++){
            int x = distinct.get(i);
            for(int j = i + 1; j < distinct.size(); j++){
                int y = distinct.get(j);
                if(!mp.get(x).equals(mp.get(y))){
                    return new int[]{x,y};
                }
            }
        }
        return new int[]{-1, -1};
        
    }
}