class Solution {
    public int singleNumber(int[] nums) {
        
        int numOut = 0;
        
        for (int num : nums) {
            numOut ^= num;
        }
        
        return numOut;
        
    }
}