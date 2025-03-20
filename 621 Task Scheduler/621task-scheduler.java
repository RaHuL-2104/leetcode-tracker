class Solution {
    public int leastInterval(char[] tasks, int n) {
        int size = tasks.length;
        if(n == 0)
            return size;
        int counter[] =new int[26] ;
        for(char ch : tasks){
            counter[ch - 'A']++;
        }
        Arrays.sort(counter);
        int chunks = counter[25]-1;
        int idolSpots = chunks*n;
        for(int i = 24;i>=0;i--){
            idolSpots -= Math.min(chunks,counter[i]);
        }
        if(idolSpots > 0){
            return size + idolSpots;
        }
        return size;
    }
}