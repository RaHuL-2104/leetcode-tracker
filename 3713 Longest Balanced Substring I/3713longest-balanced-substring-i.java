class Solution {
    public int longestBalanced(String s) {
        // HashMap for storing all the distinct characters and their frequency
        int n = s.length();
        // a = 2
        // b = 2
        // c = 1
        int maxLength = 0;
        for(int i = 0; i < n; i++){
            HashMap<Character, Integer> mp = new HashMap<>();
            for(int j = i; j < n; j++){
                mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);
                if(isBalanced(mp,mp.get(s.charAt(j)))){
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }
    public boolean isBalanced(HashMap<Character, Integer> mp, int v){
        // check if map ka value = to current freq count
        for(int count: mp.values()){
            if(count != v){
                return false;
            }
        }
        return true;
    }
}