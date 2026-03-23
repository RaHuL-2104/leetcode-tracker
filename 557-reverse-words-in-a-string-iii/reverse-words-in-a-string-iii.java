class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        for(String wd : s.split(" ")){
            char ch[] = wd.toCharArray();
            int left = 0;
            int right = ch.length - 1;
            while(left < right){
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
            res.append(new String(ch)).append(" ");
        }
       return res.toString().trim();
    }
}