class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int num : nums){
            mp.put(num, mp.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                if(mp.get(a) == mp.get(b)){
                    return b-a;
                }
                return mp.get(a) - mp.get(b);
            }
        });
        for(Integer key : mp.keySet()){
            pq.offer(key);
        }
        int i = 0;
        while(!pq.isEmpty()){
            int key = pq.poll();
            int f = mp.get(key);
            for(int j = 0; j < f; j++){
                nums[i] = key;
                i++;
            }
        }
        return nums;

    }
}