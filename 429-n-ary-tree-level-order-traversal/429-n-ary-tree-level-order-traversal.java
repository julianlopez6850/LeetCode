/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    List<Integer> list = new ArrayList<Integer>();
    Queue<Node> queue = new LinkedList<Node>();
    
    public List<List<Integer>> levelOrder(Node root) {
        queue.add(null);
        if(root != null)
            levelOrderTraversal(root);
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<Integer>();
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i) != null)
            {
                temp.add(list.get(i));
            }
            if(list.get(i) == null || i == list.size() - 1)
            {
                result.add(temp);
                temp = new ArrayList<Integer>();
            }
        }
        return result;
    }
    
    public List<Integer> levelOrderTraversal(Node root) {
        if(root != null)
        {
            list.add(root.val);
            
            for(int i = 0; i < root.children.size(); i++)
            {
                if(root.children.get(i) != null)
                    queue.add(root.children.get(i));
            }
        }
        else if(queue.size() > 0)
        {
            list.add(null);
            queue.add(null);
        }
        if(queue.size() > 0)
            levelOrderTraversal(queue.remove());
        return list;
    }
}