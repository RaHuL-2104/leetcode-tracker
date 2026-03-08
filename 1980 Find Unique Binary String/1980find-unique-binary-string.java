class Solution {
    public String findDifferentBinaryString(String[] nums) {
        // convert the strings to base 10 integers
        // store them in a hashset/ hashmap
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(String str : nums){
            set.add(Integer.parseInt(str, 2));
        }
        int val= (int)Math.pow(2,n);
        for(int i = 0; i < val; i++){
            if(!set.contains(i)){
                String s = Integer.toBinaryString(i);
                if(s.length() == n) return s;
                int len = s.length();
                for(int j = 0; j < n-len; j++){
                    s="0"+s;
                }
                return s;
            }
        }
        return "";
    }
}