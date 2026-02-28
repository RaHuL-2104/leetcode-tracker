class Solution {
    public String mergeCharacters(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        boolean merged = true;
        while(merged){
            merged = false;
            int n = sb.length();
            for(int i = 0; i < n; i++){
                for(int j = i + 1; j < n && j <= i + k; j++){
                    if(sb.charAt(i) == sb.charAt(j)){
                        sb.deleteCharAt(j);
                        merged = true;
                        break;
                    }
                }
                if(merged) break;
            }
        }
        return sb.toString();
    }
}