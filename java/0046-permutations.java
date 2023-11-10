class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, new ArrayList<Integer>(), new boolean[nums.length], nums);
        return results;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> curResult, boolean[] used, int[] nums){
        if(curResult.size() == nums.length) {
            result.add(new ArrayList<>(curResult));
            return;
        }
        
        for (int i=0; i < nums.length; i++){
            if (used[i]) continue;
            used[i] = true;
            curResult.add(nums[i]);
            dfs(result, curResult, used, nums);
            used[i] = false;
            curResult.remove(curResult.size()-1);
        }
    }
}