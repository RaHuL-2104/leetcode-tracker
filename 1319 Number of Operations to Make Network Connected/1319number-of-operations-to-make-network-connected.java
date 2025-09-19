class Solution {
    private int[] parent;
    private int[] rank;

    public int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public void Union(int x, int y){
        int pX = find(x);
        int pY= find(y);
        if(pX == pY)
            return;
        if(rank[pX] > rank[pY]){
            parent[pY] = pX;
        } else if(rank[pX] < rank[pY]){
            parent[pX] = pY;
        }else{
            parent[pX] = pY;
            rank[pY]++;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1){
            return -1;
        }
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        int components = n;

        for(int[] conn : connections){
            if(find(conn[0]) != find(conn[1])){
                Union(conn[0], conn[1]);
                components--;
            }
        }
        return components - 1;
    }
}