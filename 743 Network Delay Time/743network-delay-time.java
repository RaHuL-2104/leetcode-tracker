class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>(n + 1);
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] t : times){
            int u = t[0];
            int v = t[1];
            int w = t[2];
            adj.get(u).add(new int[]{v,w});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0,k});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int d = cur[0];
            int node = cur[1];

            if(d > dist[node]) continue;

            for(int[] edge : adj.get(node)){
                int neighbor = edge[0];
                int w = edge[1];

                if((long) d + w < dist[neighbor]){
                    dist[neighbor] = d + w;
                    pq.add(new int[]{dist[neighbor],neighbor});
                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            ans = Math.max(ans,dist[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}