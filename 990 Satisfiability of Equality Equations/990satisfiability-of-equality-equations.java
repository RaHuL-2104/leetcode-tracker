class Solution {
    private int[] rank;
    private int[] parent;

    private int find(int i){
        if(parent[i] != i){
            parent[i] = find(parent[i]); // path compression
        }
        return parent[i];
    }

        private void union(int x, int y){
            int pX = find(x);
            int pY = find(y);

            if(pX != pY){
                if(rank[pX] > rank[pY]){
                    parent[pY] = pX;
                } else if(rank[pY] > rank[pX]){
                    parent[pX] = pY;
                } else{
                    parent[pX] = pY;
                    rank[pY]++;
                }
            }
        }
    public boolean equationsPossible(String[] equations) {
       parent = new int[26];
       rank = new int[26];

       for(int i = 0; i < 26; i++){
        parent[i] = i;
        rank[i] = 1;
       }

       // Process equations with "=="
       for(String s: equations){
        if(s.charAt(1) == '='){
            union(s.charAt(0) - 'a',s.charAt(3) - 'a');
        }
       }

       // Process equations with "!="
       for(String s: equations){
            if(s.charAt(1) == '!'){
                if(find(s.charAt(0) - 'a') == find(s.charAt(3) - 'a')){
                    return false;
                }
            }
       }
       return true;
    }
}