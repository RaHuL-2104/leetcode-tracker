class Solution {
    public boolean checkOnesSegment(String s) {
        // int len = s.length();
        // int maxLength = 0;
        // for(int i = 0; i < len; i++){
        //     int length = 0;
        //     for(int j = i+1; j < len; j++){
        //         if(s.charAt(i) == s.charAt(j)){
        //             length++;
        //             maxLength = Math.max(maxLength, length);
        //         }
        //     }
        // }
        // if(maxLength >= 1){
        //     return true;
        // }
        // return false;
        return !s.contains("01");
    }
}