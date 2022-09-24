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
    
    List<List<Integer>> intList = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return intList;
        
        pathSumHelper(root, targetSum, 0, new ArrayList<Integer>());
        return intList;
    }
    
    public void pathSumHelper(TreeNode root, int targetSum, int sum, List<Integer> currList)
    {
        sum += root.val;
        currList.add(root.val);
        
        if(root.left == null && root.right == null && sum == targetSum)
        {
            intList.add(new ArrayList<>(currList));
            return;
        }
        if(root.left != null)
        {
            pathSumHelper(root.left, targetSum, sum, currList);
            currList.remove(currList.size() - 1);
        }
        if(root.right != null)
        {
            pathSumHelper(root.right, targetSum, sum, currList);
            currList.remove(currList.size() - 1);
        }
        return;        
    }
}