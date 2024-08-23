class Solution {
public:
    void reverseString(vector<char>& c) {
        int s= 0;
        int e = c.size()-1;
        while(s<e){
            swap(c[s++],c[e--]);
        }
    }
};