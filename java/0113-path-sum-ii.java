/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        return pathSum(root, targetSum, new ArrayList<>());

        
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum, List<Integer> curList){
        if (root == null){
            return new ArrayList<>();
        } 
        
        List<List<Integer>> allResults = new ArrayList<>();
        if (root.val == targetSum && root.left == null && root.right == null) {
            curList.add(root.val);
            allResults.add(new ArrayList<>(curList));
            
        } else {
        
            curList.add(root.val);
            List<List<Integer>> leftResult = pathSum(root.left, targetSum - root.val, curList);
            List<List<Integer>> rightResult = pathSum(root.right, targetSum - root.val, curList);

            if(!leftResult.isEmpty()) allResults.addAll(leftResult);
            if(!rightResult.isEmpty()) allResults.addAll(rightResult);
            
        }
        
        curList.remove(curList.size()-1);
        return  allResults;
        
        
    }
}