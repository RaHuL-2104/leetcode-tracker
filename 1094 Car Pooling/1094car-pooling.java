class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b) -> a[1]-b[1]);
        int N = trips.length;
        PriorityQueue<int[]> endTimesPQ = new PriorityQueue<int[]>((a,b) ->a[2] - b[2]);
        int passengers = 0;
        for(int i = 0; i < N; i++){
            int currStart = trips[i][1];
            // if no overlaps keep removing the trips that ends soonest and along w its
            // passengers
            while(!endTimesPQ.isEmpty() && currStart >= endTimesPQ.peek()[2]){
                int got_down = endTimesPQ.poll()[0];
                passengers -= got_down;
            }
            passengers += trips[i][0];
            endTimesPQ.add(trips[i]);
            if(passengers > capacity)
                return false; 
        }
        return true;
    }
}