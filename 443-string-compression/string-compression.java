class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int i = 0;
        int n = chars.length;
        while(i < n){
            char current = chars[i];
            int count = 0;
            while(i < n && chars[i] == current){
                i++;
                count++;
            }
            chars[index++] = current;
            if(count > 1){
                String c = Integer.toString(count);
                for(char ch : c.toCharArray()){
                    chars[index++] = ch;
                }
            }
        }
        return index;
    }
}