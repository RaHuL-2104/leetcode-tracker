class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        // Loop through each row and store frequency in hashmap
        // store those elements where freq is 0 and 2
        int n = grid.length;
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int[] row: grid){
            for(int num : row){
                if(set.contains(num)){
                    res.add(num);
                }
                set.add(num);
            }
        }
        for(int i = 1; i <= n*n; i++){
            if(!set.contains(i)){
                res.add(i);
            }
        }
        int[] result = res.stream().mapToInt(i -> i.intValue()).toArray();
        return result;
    }
}
