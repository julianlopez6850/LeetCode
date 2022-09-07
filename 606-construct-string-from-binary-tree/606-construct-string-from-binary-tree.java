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
    
    StringBuilder str = new StringBuilder();
    
    public String tree2str(TreeNode root) {
        str.append(root.val);
        if(root.left != null)
        {
            str.append("(");
            tree2str(root.left);
            str.append(")");
        }
        else if(root.right != null)
            str.append("()");

        if(root.right != null)
        {
            str.append("(");
            tree2str(root.right);
            str.append(")");
        }
        return str.toString();
    }
}