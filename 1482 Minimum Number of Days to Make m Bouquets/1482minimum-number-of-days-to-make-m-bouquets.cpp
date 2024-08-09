class Solution {
public:
    bool possible(vector<int>& arr, int day,int m, int k ){
        int count = 0;
        int numOfB = 0;
        for(int i=0;i<arr.size();i++){
            if(arr[i] <= day){
                count++;
                if(count == k){
                    numOfB ++;
                    count =0;
                }
            }
            else{
                count=0;
            }
        }
        return numOfB >=m ;
    }
    int minDays(vector<int>& bloomDay, int m, int k) {
        long long val = m * 1LL * k * 1LL;
        if(val>bloomDay.size()) return -1;
        int min1 = *min_element(bloomDay.begin(),bloomDay.end());
        int max1 = *max_element(bloomDay.begin(),bloomDay.end());
        int low = min1,high = max1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(possible(bloomDay,mid,m,k)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
};