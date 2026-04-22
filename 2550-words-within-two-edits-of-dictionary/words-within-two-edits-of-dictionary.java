// Loop through all words in queries and dictionary check whether in each word characters are same, if not same then increase count
// if count <= 2 then add that word in resultant list otherwise break;

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for(String q : queries){
            for(String d : dictionary){
                int count = 0;
                for(int i = 0; i < q.length(); i++){
                    if(q.charAt(i) != d.charAt(i)){
                        count++;
                    }
                    if(count > 2){
                        break;
                    }
                }
                if(count <= 2){
                    res.add(q);
                    break;
                }
            }
        }
        return res;
    }
}
