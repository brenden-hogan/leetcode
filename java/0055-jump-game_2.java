enum State {
    G, B, UK
}
class Solution {
    State[] memo;
    
    public boolean canJump(int[] nums) {
        memo = new State[nums.length];
        
        for(int i=0; i < memo.length; i++){
            memo[i] = State.UK;
        }
        memo[memo.length - 1] = State.G;
        return jump(0, nums);
    }
    
    
    public boolean jump(int position, int[] nums){
        if(memo[position] != State.UK){
            return memo[position] == State.G ? true : false;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for(int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++){
            if(jump(nextPosition, nums)){
                memo[position] = State.G;
                return true;
            }
        }
        memo[position] = State.B;
        return false;
        
    }
}