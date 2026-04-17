class Solution {
    public int getReverse(int num){
        int rev = 0;
        while(num != 0){
            int d = num%10;
            rev = rev * 10 + d;
            num = num/10;
        }
        return rev;
    }
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        // storing the reversed of the number and its index
        HashMap<Integer, Integer> mp = new HashMap<>(); 
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(mp.containsKey(nums[i])){
                minDist = Math.min(minDist ,i - mp.get(nums[i]));
            }
            mp.put(getReverse(nums[i]), i);
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}