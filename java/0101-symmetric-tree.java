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
    public boolean isSymmetric(TreeNode root) {
        if(root.left !=null && root.right != null) {
            return isMirror(root.left, root.right);
        } else if (root.left != null || root.right != null){
            return false;
        }
        return true;
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        System.out.println(left.val + " : " + right.val);
        if (left.val != right.val){
            return false;
        }

        boolean side1 = true;
        if (left.left != null && right.right != null){
            side1 = isMirror(left.left, right.right);
        } else if(left.left != null || right.right != null){
            return false;
        }

        boolean side2 = true;
        if (left.right != null && right.left != null){
            side2 = isMirror(left.right, right.left);
        } else if(left.right != null || right.left != null){
            return false;
        }

        return side1 && side2;
    }
}