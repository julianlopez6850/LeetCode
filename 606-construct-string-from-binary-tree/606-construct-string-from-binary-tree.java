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
    
    
    public String tree2str(TreeNode root) {
        StringBuilder str = new StringBuilder();
        tree2strHelper(root, str);
        return str.toString();
    }
    
    public void tree2strHelper(TreeNode root, StringBuilder str)
    {
        str.append(root.val);
        if(root.left != null)
        {
            str.append("(");
            tree2strHelper(root.left, str);
            str.append(")");
        }
        else if(root.right != null)
            str.append("()");

        if(root.right != null)
        {
            str.append("(");
            tree2strHelper(root.right, str);
            str.append(")");
        }
    }
}