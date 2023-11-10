class Solution {
    public int removeDuplicates(int[] nums) {
        
        int prev = nums[0];
        int endIndex = nums.length-1;
        for (int i=1; i <= endIndex; i++){
            //printArray(nums);
            if (nums[i] == prev){
                for(int j=i; j< endIndex; j++){
                    nums[j] = nums[j+1];
                }
                endIndex--;
                i--;
            } else {
                prev = nums[i];
            }
        }
        //printArray(nums);
        return endIndex+1;
    }
    public void printArray(int[] nums){
        for(int val: nums){
            System.out.print(val + ",");
        }
        System.out.println();
    }
}
    