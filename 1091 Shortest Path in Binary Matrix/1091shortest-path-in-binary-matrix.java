class Solution {
    private static final int[][] DIRECTIONS = {
        {1,1},{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{1,-1},{-1,1}
    };

    private static class Node implements Comparable<Node>{
        int dist;
        int x;
        int y;
        Node(int dist, int x, int y){
            this.dist = dist;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node other){
            return Integer.compare(this.dist, other.dist);
        }
    }
    private boolean isSafe(int x, int y, int m, int n){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0] != 0) return -1;

        int INF = Integer.MAX_VALUE;
        int[][] result = new int[m][n];
        for(int[] row : result ) Arrays.fill(row,INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0,0));
        result[0][0] = 0;
        grid[0][0] = 1;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int d = cur.dist;
            int x = cur.x;
            int y = cur.y;

            if(d > result[x][y]) continue;
            for(int[] dir : DIRECTIONS){
                int nx = x + dir[0];
                int ny = y + dir[1];
                int nd = d + 1;

                if(isSafe(nx,ny,m,n) && grid[nx][ny] == 0 && nd < result[nx][ny]){
                    result[nx][ny] = nd;
                    pq.add(new Node(nd,nx,ny));
                    grid[nx][ny] = 1;
                }
            }
        }
        if(result[m-1][n-1] == INF) return -1;
        return result[m-1][n-1] + 1;
    }
}