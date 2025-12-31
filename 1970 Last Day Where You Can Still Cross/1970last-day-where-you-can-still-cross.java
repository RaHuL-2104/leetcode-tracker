class Solution {
    int ROW;
    int COL;
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    private boolean bfs(int[][] grid, int i , int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        grid[i][j] = 1;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];

            if(x == ROW - 1){
                return true;
            }

            for(int[] dir: directions){
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(newX >= 0 && newX < ROW && newY >= 0 && newY < COL && grid[newX][newY] == 0){
                    q.offer(new int[]{newX, newY});
                    grid[newX][newY] = 1;
                }
            }
        }
        return false;
    }
    private boolean canCross(int[][] cells, int day){
        int[][] grid = new int[ROW][COL];
        for(int i = 0; i <= day; ++i){
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;

            grid[r][c] = 1;
        }
        for(int j = 0; j < COL; j++){
            if(grid[0][j] == 0 && bfs(grid, 0, j)){
                return true;
            }
        }
        return false;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        ROW = row;
        COL = col;

        int n = cells.length;
        int l = 0;
        int r = n - 1;
        int lastDay = 0;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(canCross(cells,mid)){
                lastDay = mid+1;
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return lastDay;
    }
}