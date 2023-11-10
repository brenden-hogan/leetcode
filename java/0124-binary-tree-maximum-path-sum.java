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
    private int globalMax;
    
    public int maxPathSum(TreeNode root) {
        globalMax = Integer.MIN_VALUE;
        maxSum(root);
        return globalMax;
    }
    
    public int maxSum(TreeNode tn) {
        if (tn == null) return 0;
        
        int maxLeft = maxSum(tn.left);
        int maxRight = maxSum(tn.right);
        
        maxLeft = Math.max(maxLeft, 0);
        maxRight = Math.max(maxRight, 0);
        
        int localMax = maxLeft + maxRight + tn.val;
        
        globalMax = Math.max(localMax, globalMax);
        
        return Math.max(maxLeft, maxRight) + tn.val;
    }
}