class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long total = mass;
        int n = asteroids.length;
        for(int i = 0; i < n; i++){
            if(total >= asteroids[i]){
                total += asteroids[i];
            } else{
                return false;
            }
        }
        return true;
    }
}
