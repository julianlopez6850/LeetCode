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
    
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    Queue<Integer> columnQueue = new LinkedList<Integer>();
    List<Integer> levelOrder = new ArrayList<Integer>();
    List<Integer> columnList = new ArrayList<Integer>();
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        queue.add(null);
        levelOrderTraversal(root, 0);
        
        List<Integer> columns = new ArrayList<Integer>();
        columns.add(0);
        
        // fill up unique columns into arrayList columns
        for(int i = 0; i < columnList.size(); i++)
        {
            if(columnList.get(i) != null)
                for(int j = 0; j < columns.size(); j++)
                {
                    if(columnList.get(i) == columns.get(j))
                       break;
                    else if(j == columns.size() - 1)
                       columns.add(columnList.get(i));
                }
        }
        // order columns from least to greatest
        for(int i = 1; i < columns.size(); i++)
        {
            for(int j = 1; j < columns.size(); j++)
            {
                if(columns.get(j) < columns.get(j - 1))
                {
                    int temp = columns.get(j);
                    columns.set(j, columns.get(j - 1));
                    columns.set(j - 1, temp);
                }
            }
        }
        
        int rowi = 0;
        int rowj = 0;
        // order nodes in same position from least to greatest value
        for(int i = 0; i < columnList.size(); i++)
        {
            if(columnList.get(i) != null)
            {
                for(int j = 0; j < columnList.size(); j++)
                {
                    if(columnList.get(j) != null)
                    {
                        if(rowi == rowj && columnList.get(i) == columnList.get(j) && levelOrder.get(i) > levelOrder.get(j) && i < j)
                        {
                            int temp = levelOrder.get(i);
                            levelOrder.set(i, levelOrder.get(j));
                            levelOrder.set(j, temp);
                        }
                    }
                    else
                        rowj++;
                }
            }
            else
                rowi++;
            rowj = 0;
        }
        
        //fill in result
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < columns.size(); i++)
        {
            List<Integer> temp = new ArrayList<Integer>();
            for(int j = 0; j < columnList.size(); j++)
                if(columnList.get(j) != null)
                    if(columnList.get(j) == columns.get(i))
                        temp.add(levelOrder.get(j));
            result.add(temp);
        }
        return result;
    }
    
    public List<Integer> levelOrderTraversal(TreeNode root, int columnNum) {
        if(root != null)
        {
            levelOrder.add(root.val);
            columnList.add(columnNum);
            if(root.left != null)
            {
                queue.add(root.left);
                columnQueue.add(columnNum - 1);
            }
            if(root.right != null)
            {
                queue.add(root.right);
                columnQueue.add(columnNum + 1);
            }
        }
        else if(queue.size() > 0)
        {
            levelOrder.add(null);
            columnList.add(null);
            queue.add(null);
        }
        if(queue.size() > 0)
        {
            TreeNode newNode = queue.remove();
            levelOrderTraversal(newNode, (newNode != null) ? columnQueue.remove() : 0);
        }
        return levelOrder;
    }
}