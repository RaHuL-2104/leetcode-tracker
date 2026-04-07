class Solution {
    // turning left by 90 : {x,y} => {-y,x}
    // turning right by 90 : {x,y} => {y, -x}
    public int robotSim(int[] commands, int[][] obstacles) {
        // to quickly store/access obstacle positions as strings
        HashSet<String> set = new HashSet<>();
        for(int[] element : obstacles){
            String key = element[0] + "_" + element[1];
            set.add(key);
        }
        int x = 0;
        int y = 0;
        int maxDist = 0;
        int[] dir = new int[]{0,1}; // for moving north
        for(int i = 0; i < commands.length; i++){
            if(commands[i] == -2){  // turning left by 90
                dir = new int[]{-dir[1], dir[0]};
            } else if(commands[i] == -1){  // turning right by 90
                dir = new int[]{dir[1], -dir[0]};
            } else{ // moving a step forward until we reach obstacles
                for(int step = 0; step < commands[i]; step++){
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    String nextKey = newX + "_" + newY;
                    if(set.contains(nextKey)){
                        break;
                    }
                    x = newX;
                    y = newY;
                }
            }
            maxDist = Math.max(maxDist, x*x + y*y);
        }
        return maxDist;
    }
}