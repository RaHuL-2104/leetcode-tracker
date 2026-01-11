class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int longestStreak = 0;
        for(int n : set){
            if(!set.contains(n - 1)){
                int currentNum = n;
                int currentStreak = 1;
                
                while(set.contains(currentNum + 1)){
                currentNum++;
                currentStreak++;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }
        }
        return longestStreak;

    }
}

// 0 3 7 2 5 8 4 6 0 1
// 0 1 2 3 4 5 6 7 8