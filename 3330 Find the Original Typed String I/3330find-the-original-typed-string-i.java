class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        char[] ch = word.toCharArray();
        int c = 0;
        for(int i = 1; i < n ; i++){
            if(ch[i] == ch[i-1]){
                c++;
            }
        }
        return c+1;
    }
}