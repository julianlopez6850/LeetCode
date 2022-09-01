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
    public int goodNodes(TreeNode root) {
        
        int greatestValue = root.val;
        
        return goodNodesHelper(root, greatestValue);
    }
    
    public int goodNodesHelper(TreeNode root, int greatestValue)
    {
        if(root != null)
        {
            if(root.val >= greatestValue)
            {
                greatestValue = root.val;
                return goodNodesHelper(root.left, greatestValue) + goodNodesHelper(root.right, greatestValue) + 1;
            }
            else
            {
                return goodNodesHelper(root.left, greatestValue) + goodNodesHelper(root.right, greatestValue);
            }
        }
        return 0;
    }
}