// using merge sort
class Solution {
    private void mergeSort(int[] nums,int low,int high){
        if(low>=high)
            return;
        int mid = (low+high)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }
    private static void merge(int[] nums,int low,int mid,int high){
        ArrayList<Integer> arr = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left<= mid && right <= high){
            if(nums[left] <= nums[right]){
                arr.add(nums[left]);
                left++;
            }
            else{
                arr.add(nums[right]);
                right++;
            }
        }
        while(left<=mid){
            arr.add(nums[left]);
            left++;
        }
        while(right<=high){
            arr.add(nums[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            nums[i] = arr.get(i-low);
        }
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}