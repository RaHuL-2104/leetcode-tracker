class Solution {
    private int[] parent;
    private int[] rank;

    private int find(int x){
        if(x == parent[x]){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int x, int y){
        int xParent = find(x);
        int yParent = find(y);

        if(xParent == yParent) return ;

        if(rank[xParent] > rank[yParent]){
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]){
            parent[xParent] = yParent;
        } else{
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            union(u,v);
        }

        Map<Integer, Integer> componentSize = new HashMap<>();
        for(int i = 0; i < n; i++){
            int root = find(i);
            componentSize.put(root, componentSize.getOrDefault(root, 0) + 1);
        }

        long result = 0;
        long remainingNodes = n;
        for(int size : componentSize.values()){
            long s = size;
            result += s *(remainingNodes - s);
            remainingNodes -= s;
        }
        return result;
    }
}