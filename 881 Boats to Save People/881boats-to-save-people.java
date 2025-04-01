class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int i = 0, j = n-1;
        int minBoats = 0;
        while(i <= j){
            if(people[j] + people[i] <= limit){
                i++;
                j--;
            }else{
                j--;
            }
            minBoats++;
        }
        return minBoats;
    }
}