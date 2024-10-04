class Solution {
public:
    long long dividePlayers(vector<int>& skill) {
        long sum =0;
        vector<int> count(1001,0);
        for(int i : skill){
            sum+=i;
            count[i]+=1;
        }
        int totSkill = (int)((2*sum)/skill.size());
        long chemistry = 0;
        for(int i=1;i<=1000;i++){
            if(count[i]>0){
                if(totSkill-i >1000 || count[i]!=count[totSkill-i]) return -1;
            } else{
                continue;
            }
            if((totSkill-i)==i){
                if(count[i]%2!=0) return -1;
                chemistry += (i)*(long)(totSkill-i)*count[i]/2;
            } else {
                chemistry += (i)*(long)(totSkill-i)*count[i];
            }
            count[i] = count[totSkill-i] = 0;
        }
        return chemistry;
    }
};