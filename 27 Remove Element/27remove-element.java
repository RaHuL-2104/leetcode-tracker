class Solution {
    public int removeElement(int[] nums, int val) {
        ArrayList<Integer> l = new ArrayList<>();
        for(int num : nums){
            if(num != val){
                l.add(num);
            }
        }
        for(int i = 0;i<l.size();i++){
            nums[i] = l.get(i);
        }
        return l.size();
    }
}