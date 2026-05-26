class Solution {
    public int numberOfSpecialChars(String word) {
        int[] freq = new int[123];
        int count = 0;
        for(char ch : word.toCharArray()){
            freq[ch]++;
            // current char is lower case , look for upper case
            if(ch >= 'a' && ch <= 'z'){
                char capital = (char)(ch - 'a' + 'A');
                if(freq[ch] == 1 && freq[capital] > 0)
                    count++;
            } else{
                char lower = (char)(ch - 'A' + 'a');
                if(freq[ch] == 1 && freq[lower] > 0)
                    count++;
            }
        }
        return count;

    }
}