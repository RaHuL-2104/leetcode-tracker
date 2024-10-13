class Solution {
public:
    string removeKdigits(string num, int k) {
        stack<char> st;
        for(const char& c: num){
            while(!st.empty() && c < st.top() && k>0){
                st.pop();
                k--;
            }
            st.push(c);
        }
        while(k>0){
            st.pop();
            k--;
        }
        string res="";
        while(!st.empty()){
            res.push_back(st.top());
            st.pop();
        }
        reverse(res.begin(),res.end());
        int i = 0;
        while(res[i]=='0'){
            i++;
        }
        res = res.substr(i);
        if(res=="")
            return "0";
        return res;
    }
};