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
    
    public int minDiffInBST(TreeNode root) {
        
        inorderTraversal(root);
        
        int currDifference = 0;
        int minDifference = list.get(1) - list.get(0);
        
        for(int i = 1; i < list.size() - 1; i++)
        {
            currDifference = list.get(i + 1) - list.get(i);
            if(currDifference < minDifference)
                minDifference = currDifference;
        }
        
        return minDifference;
    }
    
    
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root != null)
        {
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }
}