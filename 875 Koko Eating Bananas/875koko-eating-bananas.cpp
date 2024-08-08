class Solution {
public:

    int maximum(vector<int>& piles){
        int n = piles.size();
        int max1 = INT_MIN;
        for(int i=0;i<n;i++){
            max1 = max(max1,piles[i]);
        }
        return max1;
    }
    long long calculateHours(vector<int>& piles,int hrs){
        long long totalH=0;
        int n = piles.size();
        for(int i=0;i<n;i++){
            totalH += ceil((double)piles[i] / (double)hrs);
        }
        return totalH;
    }

    int minEatingSpeed(vector<int>& piles, int h) {
        int low = 1,high = maximum(piles);
        while(low<=high){
            int mid = low + (high-low)/2;
            long long totalH = calculateHours(piles,mid);
            if(totalH <= h){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
};