class Solution {
public:
    int solve(vector<int>& cost,int i, vector<int>& vec){
        if(i >= cost.size()){
            return 0;
        }
        if(i == cost.size()-1){
            return cost[i];
        }
        if(vec[i] != -1){
            return vec[i];
        }
        vec[i] = min(solve(cost,i+1,vec),solve(cost,i+2,vec)) + cost[i];
        return vec[i];
    }
    int minCostClimbingStairs(vector<int>& cost) {
        vector<int> vec(cost.size(),-1);
        return min(solve(cost,0,vec),solve(cost,1,vec));
    }
};