class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map <String,List<String>> res = new HashMap<>();
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortedS = new String(ch);
            res.putIfAbsent(sortedS,new ArrayList<>());
            res.get(sortedS).add(str);
        }
        return new ArrayList<>(res.values());
    }
}