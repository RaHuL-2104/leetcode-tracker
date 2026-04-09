class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            // Odd
            int len1 = checkPalindrome(s,i,i);
            // Even
            int len2 = checkPalindrome(s,i,i+1);

            int len = Math.max(len1,len2);

            if(len > end-start){
                start = i- (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);
    }
    public int checkPalindrome(String s, int left, int right){
        while(left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))){
            left--;
            right++;
        }
        return right-left-1;
    }
}