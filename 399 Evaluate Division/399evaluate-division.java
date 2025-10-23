class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair<String,Double>>> adj = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            List<String> eq = equations.get(i);
            String a = eq.get(0);
            String b = eq.get(1);
            double value = values[i];
            adj.putIfAbsent(a, new ArrayList<>());
            adj.putIfAbsent(b, new ArrayList<>());

            adj.get(a).add(new Pair<>(b, value));
            adj.get(b).add(new Pair<>(a, 1/value));
        }
        double[] results = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++){
            List<String> q = queries.get(i);
            String src = q.get(0);
            String target = q.get(1);
            results[i] = bfs(adj,src,target);
        }
        return results;
    }

    private double bfs(Map<String, List<Pair<String, Double>>> adj, String src, String target){
        if(!adj.containsKey(src) || !adj.containsKey(target)){
            return -1.0;
        }
        Queue<Pair<String, Double>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new Pair<>(src, 1.0));
        visited.add(src);

        while(!queue.isEmpty()){
            Pair<String, Double> pair = queue.poll();
            String node = pair.getKey();
            double weight = pair.getValue();

            if(node.equals(target)){
                return weight;
            }
            for(Pair<String,Double> neighbor : adj.get(node)){
                String n = neighbor.getKey();
                double nWeight = neighbor.getValue();

                if(!visited.contains(n)){
                    queue.add(new Pair<>(n, weight*nWeight));
                    visited.add(n);
                }
            }
        }
        return -1.0;
    }
}