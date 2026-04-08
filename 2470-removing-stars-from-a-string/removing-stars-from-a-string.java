class Solution {
    public String removeStars(String s) {
        // backward traverse the string
        // for every star that we find we skip the next character
        char[] ch = s.toCharArray();
        char[] newCh = new char[ch.length];
        int j = 0;                                   
        int count = 0;
        for(int i = ch.length - 1; i >= 0; i--){
            if(ch[i] == '*'){
                count++;
            } else if(count > 0){
                count--;
            } else{
                newCh[j++] = ch[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = j - 1; i >= 0; i--){
            sb.append(newCh[i]);
        }
        return sb.toString();
    }
} 
 