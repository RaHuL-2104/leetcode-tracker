class Solution {
    public int myAtoi(String s) {
        if(s.length() == 0 || s == null) return 0;
        int n = s.length();
        // remove whitespace
        int i = 0;
        while(i < n && s.charAt(i) == ' '){
            i++;
        }
        if(i == n) return 0;
        //checking the sign
        int sign = 1;
        if(s.charAt(i) == '-'){
            sign = -1;
        }
        if(s.charAt(i) == '+' || s.charAt(i) == '-'){
            i++;
        }
        int res = 0;
        int overflow = Integer.MAX_VALUE/10;
        while(i < n){
            char currentChar = s.charAt(i);
            if(currentChar < '0' || currentChar > '9'){
                break;
            }
            if(res > overflow || res == overflow && currentChar > '7'){
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } 
            res = res * 10 + (currentChar - '0');
            i++;
        }
        return sign * res;
    }
}