class MinStack {
public:
    stack<long long> st;
    long long min1;
    MinStack() {
        while(st.empty() == false) st.pop();
        min1 = INT_MAX;
    }
    
    void push(int val) {
        long long value = val;
        if(st.empty()){
            min1 = value;
            st.push(value);
        }else{
            if(value < min1){
                st.push(2*value*1LL - min1);
                min1 = value;
            }else{
                st.push(value);
            }
        }
    }
    
    void pop() {
        if(st.empty()) return;
        long long el = st.top();
        st.pop();
        if(el < min1){
            min1 = 2*min1 -el;
        }
    }
    
    int top() {
        if(st.empty()) return -1;
        long long el = st.top();
        if(el <min1) return min1;
        return el;
    }
    
    int getMin() {
        return min1;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */