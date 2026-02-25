class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashSet for keeping track of duplicates + two pointers
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while(right < s.length()){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }
        return maxLength;
    }
}