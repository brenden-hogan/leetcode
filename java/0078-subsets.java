class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<Integer>());
        for (int num : nums){
            List<List<Integer>> tempList = new ArrayList<>(subsets);
            for (List<Integer> temp: tempList){
                List<Integer> newSet = new ArrayList<>(temp);
                newSet.add(num);
                subsets.add(newSet);
            }
        }
        return subsets;
    }
}