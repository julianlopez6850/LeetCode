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
    ArrayList<Integer> treeList = new ArrayList<>();

    public boolean isValidBST(TreeNode root)
    {
        inOrderTraversal(root);
        return isListSorted();
    }

    public void inOrderTraversal(TreeNode root)
    {
        if(root == null)
            return;
        inOrderTraversal(root.left);
        treeList.add(root.val);
        inOrderTraversal(root.right);
    }

    public boolean isListSorted()
    {
        for(int i = 1; i < treeList.size(); i++)
        {
            if(treeList.get(i) <= treeList.get(i - 1))
                return false;
        }
        return true;
    }
}