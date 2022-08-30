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
    
    List<Integer> list = new ArrayList<Integer>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root != null)
        {
            if(root.left != null)
            inorderTraversal(root.left);
            if(root.right != null)
            {
                list.add(root.val);
                inorderTraversal(root.right);
            }
            else
                list.add(root.val);
        }
        return list;
    }
}