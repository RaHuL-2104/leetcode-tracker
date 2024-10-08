class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        stack<int> st;
        for(int i = 0;i<asteroids.size();i++){
            bool flag = false;
            while(!st.empty() && asteroids[i]<0 && st.top()>0){
                if(abs(asteroids[i])>abs(st.top())){
                    st.pop();
                }
                else if(abs(asteroids[i]) == abs(st.top())){
                    st.pop();
                    flag = true;
                    break;
                }
                else{
                    flag = true;
                    break;
                }
            }
            if(!flag){
                st.push(asteroids[i]);
            }
        }
        vector<int> ans;
        while(!st.empty()){
            ans.insert(ans.begin(),st.top());
            st.pop();
        }
        return ans;
    }
};
