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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }
    
    public void helper(TreeNode root, int level, List<Integer> result){
        if(root == null) return;
        
        if(result.size() == level) {
            result.add(root.val);
        }
        helper(root.right, level+1, result);
        helper(root.left, level+1, result);
    }
}