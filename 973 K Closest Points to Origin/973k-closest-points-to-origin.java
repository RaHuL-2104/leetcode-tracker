class Solution {
    static int compare(int[] a,int[] b){
        double distance1 = (a[0]*a[0])+(a[1]*a[1]);
        double distance2 = (b[0]*b[0])+(b[1]*b[1]);
        return distance1 < distance2 ? 1:-1;
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->compare(a,b));
        for(int i = 0;i < points.length;i++){
            maxHeap.add(points[i]);
            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }
        int[][] result = new int[k][2];
        int index = 0;
        while(maxHeap.size() > 0){
            result[index++] = maxHeap.remove();
        }       
        return result;
    }
}