class Solution {
public:
    vector<int> findNse(vector<int> &arr) {
        vector<int> nse(arr.size());
        stack<int> st;
        for (int i = arr.size() - 1; i >= 0; --i) {
            while (!st.empty() && arr[st.top()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.empty() ? arr.size() : st.top();
            st.push(i);
        }
        return nse;
    }

    vector<int> findPsee(vector<int> &arr) {
        vector<int> pse(arr.size(), -1);
        stack<int> st;
        for (int i = 0; i < arr.size(); ++i) {
            while (!st.empty() && arr[st.top()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.empty() ? -1 : st.top();
            st.push(i);
        }
        return pse;
    }

    long long sumSubarrayMins(vector<int>& arr) {
        int MOD = (int)1e9 + 7;
        long long sum = 0;

        vector<int> nse = findNse(arr);
        vector<int> pse = findPsee(arr);

        for (int i = 0; i < arr.size(); ++i) {
            long long left = i - pse[i];
            long long right = nse[i] - i;
            sum = (sum + (left * right * 1LL * arr[i]));
        }
        return sum;
    }

    vector<int> nextGreaterElements(vector<int>& nums) {
        int n = nums.size();
        vector<int> nge(n, n); 
        stack<int> st;
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && nums[st.top()] < nums[i]) {
                st.pop();
            }
            if (!st.empty()) {
                nge[i] = st.top();
            }
            st.push(i);
        }
        return nge;
    }

    vector<int> previousGreater(vector<int> &nums) {
        int n = nums.size();
        vector<int> maxPrev(n, -1);
        stack<int> st;
        for (int i = 0; i < n; i++) {
            while (!st.empty() && nums[st.top()] <= nums[i]) {
                st.pop();
            }
            if (!st.empty()) {
                maxPrev[i] = st.top();
            }
            st.push(i);
        }
        return maxPrev;
    }

    long long sumSubarrayMaxs(vector<int> &nums) {
        int MOD = (int)1e9 + 7;
        long long sum = 0;

        vector<int> nge = nextGreaterElements(nums);
        vector<int> pge = previousGreater(nums);
        for (int i = 0; i < nums.size(); ++i) {
            long long left = i - pge[i];
            long long right = nge[i] - i;
            sum = (sum + (left * right * 1LL * nums[i]));
        }
        return sum;
    }

    long long subArrayRanges(vector<int>& nums) {
        long long mini = sumSubarrayMins(nums);
        long long maxi = sumSubarrayMaxs(nums);
        return maxi - mini;
    }
};