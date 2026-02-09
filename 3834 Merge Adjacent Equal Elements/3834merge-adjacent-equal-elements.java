class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        ArrayList<Long> list = new ArrayList<>();
        Stack<Long> st = new Stack<>();
        for(int n : nums){
            long i = (long)n;
            while(!st.isEmpty() && st.peek() == i){
                st.pop();
                i *= 2;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            list.add(st.pop());
        }
        Collections.reverse(list);
        return list;
        // for(int n : nums){
        //     list.add((long)n);
        // }
        // boolean changed = true;
        // while(changed){
        //     changed = false;
        //     for(int i = 0; i < list.size() - 1; i ++){
        //         if(list.get(i).equals(list.get(i+1))){
        //             long sum = list.get(i) + list.get(i+1);
        //             list.set(i,sum);
        //             list.remove(i+1);
        //             changed = true;
        //             break;
        //         }
        //     }
        // }
        // return list;
    }
}