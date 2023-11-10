class Solution {
    public int removeElement(int[] nums, int val) {
        int nextElement = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == val){
                //skip val
            } else {
                nums[nextElement] = nums[i];
                nextElement++;
            }
        }
        return nextElement;
    }
}