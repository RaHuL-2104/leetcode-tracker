class Solution {
    // undirected tree
    // tree could have more than one children
    // find the depth
    static final long MOD = 1000000007L;
    private long power(long base, long exponent){
        if(exponent == 0){
            return 1;
        }

        long half = power(base, exponent / 2);
        long result = (half * half) % MOD;

        if(exponent % 2 == 1){
            result = (result * base) % MOD;
        }
        return result;
    }
    private int getMaxDepth(Map<Integer, List<Integer>> adj, int node, int parent){
        int depth = 0;
        for(int neighbor : adj.getOrDefault(node, new ArrayList<>())){
            if(neighbor == parent){
                continue;
            }
            depth = Math.max(depth, getMaxDepth(adj, neighbor, node) + 1);
        }
        return depth;
    }
    public int assignEdgeWeights(int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        int maxDepth = getMaxDepth(adj, 1, 0);

        return (int) power(2, maxDepth - 1);
    }
}