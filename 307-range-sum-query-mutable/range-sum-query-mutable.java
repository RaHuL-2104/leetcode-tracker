class NumArray {
    public int[] nums;
    public int[] blocks;
    public int n;
    public int blockSize;
    public NumArray(int[] nums) {
        this.nums=nums;
        n = nums.length;
        blockSize = (int) Math.ceil(Math.sqrt(n));
        blocks = new int[blockSize];

        // building blocks array
        for(int i = 0; i < n; i++){
            int blockIndex = i/blockSize;
            blocks[blockIndex] += nums[i];
        }
    }
    
    public void update(int index, int val) {
        int blockIndex = index/blockSize;
        blocks[blockIndex] -= nums[index];
        blocks[blockIndex] += val;
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        // Case1: both left and right are in same block
        int startBlock = left/blockSize;
        int endBlock = right/blockSize;
        if(startBlock == endBlock){
            for(int i = left; i <= right; i++){
                sum += nums[i];
            }
            return sum;
        }

        //Case2: left and right are in different blocks
        // left partial block + middle block + right partial block
        // Left partial => Left to endOfStartBlock
        int endIndexOfStartBlock = ((startBlock + 1) * blockSize) - 1;
        for(int i = left; i <= endIndexOfStartBlock; i++){
            sum += nums[i];
        }

        // Middle full Blocks
        for(int i = startBlock+1; i <= endBlock - 1; i++){
            sum += blocks[i];
        }

        // Right partial => startOfEndBlock to Right
        int startIndexOfEndBlock = endBlock * blockSize;
        for(int i = startIndexOfEndBlock ; i <= right; i++){
            sum += nums[i];
        }
    return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */