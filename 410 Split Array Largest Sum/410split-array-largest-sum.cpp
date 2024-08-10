class Solution {
public:
    bool isValidSplit(vector<int>& nums,int m, long long maxSum){
        int count = 1;
        long long sum = 0;
        for(int num:nums){
            sum+=num;
            if(sum > maxSum){
                sum = num;
                count++;
                if(count > m){
                    return false;
            }
        }
        } return true;
    }
    int splitArray(vector<int>& nums, int k) {
        long long left = *max_element(nums.begin(),nums.end());
        long long right = accumulate(nums.begin(),nums.end(),0LL);
        long long result = right;
        while(left<=right){
            long long mid = left +(right-left)/2;
            if(isValidSplit(nums,k,mid)){
                result = mid;
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }
        return result;
    }
};