class Solution {
    public boolean backspaceCompare(String s, String t) {
        // Using the Stack approach
        // Stack<Character> st1 = new Stack<>();
        // Stack<Character> st2 = new Stack<>();
        // for(char x : s.toCharArray()){
        //     if(x != '#'){
        //         st1.push(x);
        //     }else if(!st1.isEmpty()){
        //         st1.pop();
        //     }
        // }

        // for(char x : t.toCharArray()){
        //     if(x != '#'){
        //         st2.push(x);
        //     }else if(!st2.isEmpty()){
        //         st2.pop();
        //     }
        // }
        // return st1.equals(st2);

        // Using two-pointer method to reduce space complexity
        // Traversing from the back to reduce constant deletions because of the # character
        int i =  s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;
        while(i >= 0 || j >= 0){
            while(i >= 0){
                if(s.charAt(i) == '#'){
                    skipS++;
                    i--;
                }
                else if(skipS > 0){
                    skipS--;
                    i--;
                } else{
                    break;
                }
            }

            while(j >= 0){
                if(t.charAt(j) == '#'){
                    skipT++;
                    j--;
                } else if(skipT > 0){
                    skipT--;
                    j--;
                } else{
                    break;
                }
            }

            char first = (i < 0) ? '$' : s.charAt(i);
            char second = (j < 0) ? '$' : t.charAt(j);
            if(first != second){
                return false;
            }

            i--;
            j--;
        }
        return true;
    }
}