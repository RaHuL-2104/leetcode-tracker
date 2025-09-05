class Solution {
    private boolean topologicalSortCheck(ArrayList<ArrayList<Integer>> adj,int n, int[] indegree ){
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                count++;
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int v : adj.get(u)){
                indegree[v]--;
                if(indegree[v] == 0){
                    count++;
                    queue.offer(v);
                }
            }
        }
        return count==n;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Arrays.fill(indegree,0);
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int a = pre[0];
            int b = pre[1];

            adj.get(b).add(a);
            indegree[a]++;
        }
        return topologicalSortCheck(adj,numCourses,indegree);
    }
}