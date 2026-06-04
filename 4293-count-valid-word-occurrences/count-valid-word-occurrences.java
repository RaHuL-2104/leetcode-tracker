class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        // concatenate the chunks
        // check if a chunk is a joiner hyphen
        StringBuilder sb = new StringBuilder();
        for(String w : chunks){
            sb.append(w);
        }
        String s = sb.toString();
        HashMap<String, Integer> freq = new HashMap<>();
        StringBuilder word = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLowerCase(c)){
                word.append(c);
            }
            else if(c == '-'){
                if(word.length() > 0 && i+1 < s.length() && Character.isLowerCase(s.charAt(i+1))){
                    word.append(c);
                } else{
                    addWord(freq, word);
                }
            } else{
                addWord(freq, word);
            }
        }
        addWord(freq, word);
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            ans[i] = freq.getOrDefault(queries[i], 0);
        }
        return ans;
    }
    private void addWord(Map<String, Integer> freq, StringBuilder word){
        if(word.length() == 0) return;
        String w = word.toString();
        if(w.charAt(w.length() - 1) == '-'){
            w = w.substring(0, w.length() - 1);
        }

        if(!w.isEmpty()){
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }
        word.setLength(0);
    }
}

// a-b a--b a-b
// a-b => contains a joiner hyphen
// a--b isn't so a and b is considered different 