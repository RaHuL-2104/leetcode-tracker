class Solution {
    public boolean hasAlternatingBits(int n) {
        int count = 0;
        String binary = Integer.toBinaryString(n);
        // for(int i = 1; i < binary.length(); i++){
        //     if(binary.charAt(i-1) == binary.charAt(i))
        //         count++;
        // }
        // if(count == 0){
        //     return true;
        // }
        // return false; 
        for(int i = 0; i < binary.length() - 1; i++){
            if(binary.charAt(i) == binary.charAt(i+1)){
                return false;
            }
        }
        return true;  
    }
}