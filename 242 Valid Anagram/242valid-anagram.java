class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> h1 = new HashMap<>();
        HashMap<Character,Integer> h2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            h1.put(s.charAt(i), h1.getOrDefault(s.charAt(i), 0) + 1);
            h2.put(t.charAt(i), h2.getOrDefault(t.charAt(i), 0)+ 1);
        }
        return h1.equals(h2);
    }
}