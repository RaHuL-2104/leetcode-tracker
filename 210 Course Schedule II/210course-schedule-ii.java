class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] i : prerequisites){
            int a = i[0];
            int b = i[1];

            adj.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[numCourses];
        int ptr = 0;
        int count = 0;
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                ans[ptr++] = i;
                q.add(i);
                count++;
            }
        }

        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : adj.get(u)){
                indegree[v]--;
                if(indegree[v] == 0){
                    q.add(v);
                    ans[ptr++] = v;
                    count++;
                }
            }
        }
        return count == numCourses ? ans:new int[]{};
    }
}