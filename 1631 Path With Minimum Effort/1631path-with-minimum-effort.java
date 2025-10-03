class Solution {
    private int[][] dirs = {
        {-1,0},{0,-1},{0,1},{1,0}
    };
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] result = new int[m][n];
        for(int[] row : result) Arrays.fill(row,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0,0,0});
        result[0][0] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int diff = curr[0], x = curr[1], y = curr[2];
            if(x == m-1 && y == n-1) return diff;
            for(int[] dir : dirs){
                int nx = x + dir[0], ny = y + dir[1];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                    int newDiff = Math.max(diff,Math.abs(heights[x][y] - heights[nx][ny]));
                    if(result[nx][ny] > newDiff){
                        result[nx][ny] = newDiff;
                        pq.offer(new int[]{newDiff, nx, ny});
                    }
                }
            }
        }
        return result[m-1][n-1];
    }
}