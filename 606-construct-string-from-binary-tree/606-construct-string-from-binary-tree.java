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
    
    String result = "";
    
    public String tree2str(TreeNode root) {
        result += root.val;
        if(root.left != null)
        {
            result += "(";
            tree2str(root.left);
            result += ")";
        }
        else if(root.right != null)
            result += "()";

        if(root.right != null)
        {
            result += "(";
            tree2str(root.right);
            result += ")";
        }
        return result;
    }
}