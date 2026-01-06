class Solution {
    public int firstUniqChar(String s) {
        char[] st = s.toCharArray();
        HashMap<Character, Integer> mp = new HashMap<>();
        for(char c : st){
            mp.put(c, mp.getOrDefault(c,0) + 1);
        }
        for(int i = 0; i < st.length; i++){
            if(mp.get(st[i]) == 1){
                return i;
            }
        }
        return -1;
    }
}