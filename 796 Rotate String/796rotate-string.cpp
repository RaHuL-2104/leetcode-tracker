class Solution {
public:
    bool rotateString(string s, string goal) {
        for(int rotations = 0;rotations < s.length();rotations++){
            if(s == goal)
                return true;
            // do a rotation
            for(int i=0;i+1<s.length();i++){
                swap(s[i],s[i+1]);
            }
            
        }
        return false;
    }
};