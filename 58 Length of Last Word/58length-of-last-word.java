class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split("\\s+");
        if(words.length > 0){
            String lastWord = words[words.length - 1];
            return lastWord.length();
        }
        return 0;
    }
}