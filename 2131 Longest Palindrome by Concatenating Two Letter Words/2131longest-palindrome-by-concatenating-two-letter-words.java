class Solution {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        boolean centerUsed = false;
        int result = 0;
        for(String word: map.keySet()){
            String rev = new StringBuilder(word).reverse().toString();
        if (!word.equals(rev)) {
                if (map.containsKey(rev)) {
                    int pairs = Math.min(map.get(word), map.get(rev));
                    result += pairs * 4;
                    map.put(word, map.get(word) - pairs);
                    map.put(rev, map.get(rev) - pairs);
                }
            } else {
                int freq = map.get(word);
                result += (freq / 2) * 4;
                if (freq % 2 == 1 && !centerUsed) {
                    result += 2;
                    centerUsed = true;
                }
            }
        }
        return result;
    }
}