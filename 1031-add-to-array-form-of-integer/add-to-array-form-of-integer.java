class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
       // 15/10 = 1 carry
        // 15%10 = 5 sum
        List<Integer> result = new ArrayList<>();
        for(int i = num.length - 1; i >= 0; i--){
            k += num[i];
            result.add(k%10);
            k = k/10;
        }
        while(k > 0){
            result.add(k%10);
            k = k/10;
        }
        Collections.reverse(result);
        return result;
    }
}