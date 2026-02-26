class Solution {
    public int numSteps(String s) {
        int count = 0;
        StringBuilder str = new StringBuilder(s);
        while(str.length() > 1){
            int n = str.length();
            if(str.charAt(n-1) == '1'){ // ODD
                int i = n-1;
                while(i>= 0 && str.charAt(i) != '0'){
                    str.setCharAt(i, '0');
                    i--;
                }
                if(i < 0){
                    str.insert(0, '1');
                }
                else{  
                    str.setCharAt(i, '1');
                }
            } else{ // EVEN
                str.deleteCharAt(str.length()-1);
            }
            count++;
        }
        return count;
    }
}